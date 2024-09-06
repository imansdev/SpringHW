package com.digi.app.sources.controller;

import com.digi.app.sources.dao.Digi;
import com.digi.app.sources.model.Catalog;
import com.digi.app.sources.model.CorruptedItems;
import com.digi.app.sources.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class AppController {

    @Autowired
    private Digi digi;

    @PostMapping("/item/create")
    @ResponseBody
    public Items createItem(@RequestBody Items item) {
        digi.saveItem(item);
        return item;
    }

    @GetMapping("/items")
    @ResponseBody
    public List<Items> listItems() {
        return digi.getAllItems();
    }

    @GetMapping(value = "/item/{id}")
    @ResponseBody
    public Items getItemById(@PathVariable long id) {
        Optional<Items> item = digi.searchById(id);
        return item.get();
    }

    @PutMapping("/item/{id}/update")
    @ResponseBody
    public Items updateItem(@PathVariable long id, @RequestBody Items item) {
        Optional<Items> updatedItem = digi.updateItemById(id, item);
        return updatedItem.get();
    }

    @DeleteMapping(value = "/item/{id}/delete")
    @ResponseBody
    public String deleteItemById(@PathVariable long id) {
        boolean deleted = digi.deleteItemById(id);
        if (deleted) {
            return "item has been deleted";
        } else {
            return "notFound";
        }
    }

    @GetMapping(value = "*")
    @ResponseBody
    public String notFoundPage() {
        return "notFound";
    }

    @GetMapping("/items/filter")
    @ResponseBody
    public List<Items> filterItems(@RequestParam(required = false) String name,
            @RequestParam(required = false) Catalog catalog) {
        List<Items> filteredItems = digi.getItemsByNameAndCatalog(name, catalog);
        return filteredItems;
    }

    @PostMapping("/item/{id}/corrupt")
    @ResponseBody
    public String moveItemToCorrupted(@PathVariable long id, @RequestParam String reason) {
        digi.moveItemToCorrupted(id, reason);
        return "item has been moved to corrupte items list";
    }

    @GetMapping("/corruptedItems")
    @ResponseBody
    public List<CorruptedItems> listCorruptedItems() {
        return digi.getAllCorruptedItems();
    }

    @GetMapping("/corrupted/{id}")
    @ResponseBody
    public ResponseEntity<CorruptedItems> getCorruptedItemById(@PathVariable long id) {
        Optional<CorruptedItems> item = digi.getCorruptedItemById(id);
        return item.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/corrupted/{id}/update")
    @ResponseBody
    public String updateCorruptedItemReason(@PathVariable long id, @RequestParam String reason) {
        boolean updated = digi.updateCorruptedItemReason(id, reason);
        if (updated) {
            return "corrupted item has been updated";
        } else {
            return "notFound";
        }
    }

    @DeleteMapping("/corrupted/{id}/delete")
    @ResponseBody
    public String deleteCorruptedItem(@PathVariable long id) {
        boolean deleted = digi.deleteCorruptedItem(id);
        if (deleted) {
            return "corrupted item has been deleted from corrupted items list";
        } else {
            return "notFound";
        }
    }
}
