import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ResFrameTest {

    private ResFrame resFrame;

    @Before
    public void setUp() {
        resFrame = new ResFrame();
        resFrame.setVisible(false); // Set the frame to invisible during the test
    }

    @Test
    public void testAddButtonAction() {
        // Simulate clicking on the "Hinzufügen" (Add) button
        resFrame.tc_txt.setText("123456789"); // Fill in the TC field
        resFrame.res_txt.setText("1001"); // Fill in the Reservations Nr. field
        resFrame.date_txt.setText("2023-06-02"); // Fill in the Date field
        resFrame.comboBox.setSelectedItem("Matratzen"); // Select an item from the ComboBox

        resFrame.addButton.doClick(); // Click the "Hinzufügen" (Add) button

        // Check if a row is added to the table after the add operation
        assertEquals(1, resFrame.table.getRowCount());
        assertEquals("1001", resFrame.table.getValueAt(0, 0));
        assertEquals("123456789", resFrame.table.getValueAt(0, 1));
        assertEquals("2023-06-02", resFrame.table.getValueAt(0, 2));
        assertEquals("Matratzen", resFrame.table.getValueAt(0, 3));
    }

    @Test
    public void testDeleteButtonAction() {
        // Add a row to the table beforehand
        resFrame.b.addRow(new Object[]{"1002", "987654321", "2023-06-03", "Teppich"});

        // Set the selected row in the table
        resFrame.table.setRowSelectionInterval(0, 0);

        // Simulate clicking on the "Löschen" (Delete) button
        resFrame.deleteButton.doClick();

        // Check if the row is deleted from the table after the delete operation
        assertEquals(0, resFrame.table.getRowCount());
    }

    @Test
    public void testEditButtonAction() {
        // Add a row to the table beforehand
        resFrame.b.addRow(new Object[]{"1003", "555555555", "2023-06-04", "Sofa"});

        // Set the selected row in the table
        resFrame.table.setRowSelectionInterval(0, 0);

        // Simulate clicking on the "Bearbeiten" (Edit) button


        // Check if the changes made in the table after the edit operation
        assertEquals("555555555", resFrame.table.getValueAt(0, 1));
        assertEquals("2023-06-04", resFrame.table.getValueAt(0, 2));
        assertEquals("Sofa", resFrame.table.getValueAt(0, 3));
    }

    @Test
    public void testUpdateButtonAction() {
        // Add a few rows to the table beforehand
        resFrame.b.addRow(new Object[]{"1004", "111111111", "2023-06-05", "Gardinen"});
        resFrame.b.addRow(new Object[]{"1005", "222222222", "2023-06-06", "Hausreinigung"});

        // Simulate clicking on the "Aktualisieren" (Update) button
        resFrame.addButton.doClick();

        // Check if the table is updated after the update operation
        assertEquals(2, resFrame.table.getRowCount());
        assertEquals("1004", resFrame.table.getValueAt(0, 0));
        assertEquals("111111111", resFrame.table.getValueAt(0, 1));
        assertEquals("2023-06-05", resFrame.table.getValueAt(0, 2));
        assertEquals("Gardinen", resFrame.table.getValueAt(0, 3));
        assertEquals("1005", resFrame.table.getValueAt(1, 0));
        assertEquals("222222222", resFrame.table.getValueAt(1, 1));
        assertEquals("2023-06-06", resFrame.table.getValueAt(1, 2));
        assertEquals("Hausreinigung", resFrame.table.getValueAt(1, 3));
    }
}
