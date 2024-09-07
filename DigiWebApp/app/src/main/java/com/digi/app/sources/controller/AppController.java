package com.digi.app.sources.controller;

import com.digi.app.sources.dao.Digi;
import com.digi.app.sources.model.Catalog;
import com.digi.app.sources.model.CorruptedItems;
import com.digi.app.sources.model.Items;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class AppController {

    @Autowired
    private Digi digi;


    @ModelAttribute("catalogs")
    public List<Catalog> getCatalogs() {
        return Arrays.asList(Catalog.values());
    }

    @PostMapping("/item/create")
    public String createItem(@ModelAttribute @Validated Items item, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        digi.saveItem(item);
        return "redirect:/api/items";
    }

    @GetMapping("/item")
    public String createItemForm(Model model) {
        model.addAttribute("item", new Items());
        return "form";
    }

    @GetMapping("/items")
    public String listItems(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String catalogParam = request.getParameter("catalog");

        if (name == null && (catalogParam == null || catalogParam.isEmpty())) {
            model.addAttribute("items", digi.getAllItems());
            return "list";
        }
        /*
         * if catalog parameter is empty, and the Catalog.valueOf method throws an
         * IllegalArgumentException when it tries to convert an empty string to an enum constant
         */
        Catalog catalog = null;
        if (catalogParam != null && !catalogParam.isEmpty()) {
            try {
                catalog = Catalog.valueOf(catalogParam.toUpperCase());
            } catch (IllegalArgumentException e) {
                // Handle invalid catalog value
                model.addAttribute("error", "Invalid catalog value");
                return "list";
            }
        }

        List<Items> filteredItems = digi.getItemsByNameAndCatalog(name, catalog);
        model.addAttribute("items", filteredItems);
        return "list";
    }

    @GetMapping(value = "/item/{id}")
    public String getItemById(@PathVariable long id, Model model) {
        Optional<Items> item = digi.searchById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            return "view";
        } else {
            return "NOT FOUND";
        }
    }

    @PutMapping("/item/{id}/update")
    public String updateItem(@PathVariable long id, @ModelAttribute @Validated Items item,
            BindingResult result) {
        if (result.hasErrors()) {
            return "view";
        }
        digi.updateItemById(id, item);
        return "redirect:/api/items";
    }

    @GetMapping("/item/{id}/edit")
    public String editItemForm(@PathVariable long id, Model model) {
        Optional<Items> item = digi.searchById(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            return "view";
        } else {
            return "redirect:/api/items";
        }
    }

    @DeleteMapping(value = "/item/{id}/delete")
    public String deleteItemById(@PathVariable long id) {
        boolean deleted = digi.deleteItemById(id);
        if (deleted) {
            return "redirect:/api/items";
        } else {
            return "notFound";
        }
    }

    @GetMapping(value = "*")
    public String notFoundPage() {
        return "notFound";
    }

    // @GetMapping("/items/filter")
    // public String filterItems(@RequestParam(required = false) String name,
    // @RequestParam(required = false) Catalog catalog, Model model) {
    // List<Items> filteredItems = digi.getItemsByNameAndCatalog(name, catalog);
    // model.addAttribute("items", filteredItems);
    // return "list";
    // }

    @PostMapping("/item/{id}/corrupt")
    public String moveItemToCorrupted(@PathVariable long id, @RequestParam String reason) {
        digi.moveItemToCorrupted(id, reason);
        return "redirect:/api/items";
    }

    @GetMapping("/corruptedItems")
    public String listCorruptedItems(Model model) {
        model.addAttribute("corruptedItems", digi.getAllCorruptedItems());
        return "corrupted-list";
    }

    @GetMapping("/corrupted/{id}")
    @ResponseBody
    public ResponseEntity<CorruptedItems> getCorruptedItemById(@PathVariable long id) {
        Optional<CorruptedItems> item = digi.getCorruptedItemById(id);
        return item.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/corrupted/{id}/update")
    public String updateCorruptedItemReason(@PathVariable long id, @RequestParam String reason) {
        boolean updated = digi.updateCorruptedItemReason(id, reason);
        if (updated) {
            return "redirect:/api/corruptedItems";
        } else {
            return "NOT FOUND";
        }
    }

    @DeleteMapping("/corrupted/{id}/delete")
    public String deleteCorruptedItem(@PathVariable long id) {
        boolean deleted = digi.deleteCorruptedItem(id);
        if (deleted) {
            return "redirect:/api/corruptedItems";
        } else {
            return "notFound";
        }
    }
}
