package com.example.itembase;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @GetMapping("/all")
    public List<Item> all() {
        return itemRepository.findAll();
    }

    @PostMapping("/all")
    public Item newItem(@RequestBody Item newItem) {
        return itemRepository.save(newItem);
    }


    @GetMapping("/{id}")
    public Item one(@PathVariable Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/{id}")
    Item replaceItem(@RequestBody Item newItem,@PathVariable Long id) {

        return itemRepository.findById(id)
                .map(item -> {
                    item.setName(newItem.getName());
                    item.setCost(newItem.getCost());
                    item.setDescription(newItem.getDescription());
                    return itemRepository.save(item);

                })
                .orElseGet(() -> {
                     newItem.setId(id);
                     return itemRepository.save(newItem);
                });
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }

}
