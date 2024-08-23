package ir.freeland.spring.lifecycle.config;

import static org.mockito.Mockito.never;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ir.freeland.spring.lifecycle.beans.Character;
import ir.freeland.spring.lifecycle.beans.Item;
import ir.freeland.spring.lifecycle.beans.Student;
import ir.freeland.spring.lifecycle.beans.Weapon;
import ir.freeland.spring.lifecycle.processor.MagicBeanPostProcessor;

@Configuration
class CharacterConfig {

    @Bean
    Student iman() {
        return new Student("iman", 123);
    }

    // @Bean(initMethod = "customInit", destroyMethod = "customDestroy")
    // Character character() {
    // Character character = new Character();
    // character.setWeapon(sword());
    // character.setItem(potion());
    // return character;
    // }

    // @Bean
    // Weapon sword() {
    // return new Weapon("Sword");
    // }

    // @Bean
    // Item potion() {
    // return new Item("Health Potion");
    // }

    // @Bean
    // MagicBeanPostProcessor magicBeanPostProcessor() {
    // return new MagicBeanPostProcessor();
    // }
}
