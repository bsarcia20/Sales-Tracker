package price;

import javax.swing.*;

public class SalesTrackerGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create and configure the Swing components
            JFrame frame = new JFrame("Sales Tracker");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

            JLabel phoneLabel = new JLabel("Enter the details of the phones sold:");
            frame.add(phoneLabel);

            JTextField phonePriceField = new JTextField(10);
            JTextField phoneQuantityField = new JTextField(10);
            frame.add(new JLabel("Price:"));
            frame.add(phonePriceField);
            frame.add(new JLabel("Quantity sold:"));
            frame.add(phoneQuantityField);

            JLabel repairLabel = new JLabel("Enter the details of the repair services:");
            frame.add(repairLabel);

            JTextField repairPriceField = new JTextField(10);
            JTextField repairHoursField = new JTextField(10);
            frame.add(new JLabel("Price per hour:"));
            frame.add(repairPriceField);
            frame.add(new JLabel("Number of hours:"));
            frame.add(repairHoursField);

            JButton calculateButton = new JButton("Calculate Sales");
            frame.add(calculateButton);

            JLabel phoneSalesLabel = new JLabel();
            JLabel repairSalesLabel = new JLabel();
            frame.add(phoneSalesLabel);
            frame.add(repairSalesLabel);

            calculateButton.addActionListener(e -> {
                double phonePrice = Double.parseDouble(phonePriceField.getText());
                int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());
                double repairPrice = Double.parseDouble(repairPriceField.getText());
                int repairHours = Integer.parseInt(repairHoursField.getText());

                Phone phone = new Phone();
                RepairService repairService = new RepairService("Repair Service", repairPrice, repairHours);

                double phoneTotalSales = phone.calculateTotalSales();
                double repairTotalSales = repairService.calculateTotalSales();

                phoneSalesLabel.setText("Total sales for phones: ₱" + phoneTotalSales);
                repairSalesLabel.setText("Total sales for repair services: ₱" + repairTotalSales);
            });

            frame.setVisible(true);
        });
    }
}
