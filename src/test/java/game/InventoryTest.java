package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryTest {

    private Inventory inventory;
    private Item item1;
    private Item item2;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory(2); // Inventory size 2
        item1 = new Item('a', null, "Item 1", null);
        item2 = new Item('b', null, "Item 2", null);
    }

    @Test
    public void testGetItemsAndGet() {
        assertNotNull(inventory.getItems());
        assertEquals(2, inventory.getItems().length);
        assertNull(inventory.get(0));
    }

    @Test
    public void testAddAndIsFull() {
        assertFalse(inventory.isFull());
        
        inventory.add(item1);
        assertFalse(inventory.isFull());
        
        inventory.add(item2);
        assertTrue(inventory.isFull());

        // Try adding when already full to cover the loop ending without adding
        Item item3 = new Item('c', null, "Item 3", null);
        inventory.add(item3);
    }

    @Test
    void testInventoryFullAndRemove() {
        // test filling inventory to max capacity and then removing the item
        Inventory inv = new Inventory(1);
        assertFalse(inv.isFull());
        Item rock = new Item('r', java.awt.Color.GRAY, "rock", null);
        inv.add(rock);
        assertTrue(inv.isFull());
        inv.remove(rock);
        assertFalse(inv.isFull());
    }
}