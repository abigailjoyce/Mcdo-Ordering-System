import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class McDonaldsMenu extends JFrame {

    private JPanel welcomePanel;
    private JPanel menuPanel;
    private JTextArea orderArea;
    private double total = 0.0;

    public McDonaldsMenu() {
        setTitle("McDonald's Menu");
        setSize(600, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createWelcomePanel();
        createMenuPanel();

        setContentPane(welcomePanel);
    }

    private void createWelcomePanel() {
        ImageIcon bgIcon = new ImageIcon("2.jpg");
        Image bgImage = bgIcon.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);

        welcomePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
            }
        };

        welcomePanel.setLayout(new BorderLayout());

        JLabel overlayLabel = new JLabel("TOUCH ANYWHERE TO ORDER", SwingConstants.CENTER);
        overlayLabel.setFont(new Font("Arial", Font.BOLD, 26));
        overlayLabel.setForeground(Color.white);
        overlayLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));
        welcomePanel.add(overlayLabel, BorderLayout.SOUTH);

        welcomePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setContentPane(menuPanel);
                revalidate();
                repaint();
            }
        });
    }

    private void createMenuPanel() {
        menuPanel = new JPanel(new BorderLayout(20, 20));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("McDonald's Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setForeground(new Color(255, 69, 0));
        menuPanel.add(titleLabel, BorderLayout.NORTH);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);

        ImageIcon burgerIcon = new ImageIcon(new ImageIcon("B.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        ImageIcon chickenIcon = new ImageIcon(new ImageIcon("C.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        ImageIcon dessertIcon = new ImageIcon(new ImageIcon("D.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
         ImageIcon breakfastIcon = new ImageIcon(new ImageIcon("BF.jpg").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        ImageIcon sauceIcon = new ImageIcon(new ImageIcon("tb.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        ImageIcon happyIcon = new ImageIcon(new ImageIcon("H.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

        tabbedPane.addTab("Burgers", burgerIcon,
                createCategoryPanelWithImages(
                        new String[]{"Burger Mcdo", "Big Mac", "Quarter Pounder", "Cheeseburger Deluxe", "Crispy Chicken Sandwich Solo", "Mc Chicken Sandwich"},
                        new double[]{44, 189, 179, 79, 70, 242},
                        new String[]{
                                "Burger Mcdo.png",
                                "Big Mac.png",
                                "Quarter Pounder with cheese.png",
                                "Cheeseburger.png",
                                "McCrispy Chicken Sandwich.png",
                                "Mcchicken.jpg"
                        }));

        tabbedPane.addTab("Chicken", chickenIcon,
                createCategoryPanelWithImages(
                        new String[]{"1pc Chicken McDo", "McCrispyChicken Fillet", "1pc/McSpaghetti", "2pc Chicken", "McSpaghetti","Fries"},
                        new double[]{92, 82, 155, 183, 89, 59},
                        new String[]{
                                "1pccc.jpg",
                                "1pcChickenFillet_Plus_Rice-500.jpg",
                                "1pcChickenMcDo_Plus_Spaghetti.jpg",
                                "2pc.jpg",
                                "Spaghetti.png",
                                "Fries.jpg"
                        }));

        tabbedPane.addTab("Desserts", dessertIcon,
                createCategoryPanelWithImages(
                        new String[]{"Orange Juice", "Ice Tea", "Coke", "Coke Zero", "Coke Float", "Sprite",  "McFlurry", "Hot fudge", "Caramel ", "Cone", "Apple Pie"},
                        new double[]{55, 50, 59, 45, 69, 50, 75, 45, 45, 25, 42},
                        new String[]{
                                "ORANGE JUICE.jpg",
                                "tea.png",
                                "COKE.jpg",
                                "COKE ZERO.jpg",
                                "COKE FLOAT.jpg",
                                "sprite.png",
                                "MCFLURRY.jpg",
                                "HOT FUDGE SUNDAE.jpg",
                                "HOT CARAMEL SUNDAE.jpg",  // Fixed: Added missing image
                                "cone.jpg",
                                "PIE.jpg"
                        }));

        tabbedPane.addTab("Breakfast", breakfastIcon,
                        createCategoryPanelWithImages(
                                new String[]{"Cheesy Eggdesal", "Sausage McMuffin", "Egg McMuffin", "2pc. Hotcakes", "2pc. Hotcakes w/ Sausage","HashBrown","Sausage Platter"},
                                new double[]{55, 75, 60, 100,145,59,145},
                                new String[]{
                                        "Cheesy Eggdesal.jpg",
                                        "Sausage McMuffin with Egg.jpg",
                                        "Egg McMuffin.jpg",
                                        "2pc. Hotcakes.jpg",
                                        "2pc. Hotcakes with Sausage.jpg",
                                        "Hash Browns.jpg",
                                        "Sausage Platter with Rice.jpg"
                                }));

        tabbedPane.addTab("Happy Meal", happyIcon,
                createCategoryPanelWithImages(
                        new String[]{"1pcMcDo", "4pcNuggets", "McSpaghetti", "Burger/Fries"},
                        new double[]{120, 145, 130, 125},
                        new String[]{
                                "1pcchickHM.png",
                                "4pcnugHM.png",
                                "spagHM.png",
                                "bmHM.png"
                        }));

        tabbedPane.addTab("Sauce DIP", sauceIcon,
                createCategoryPanelWithImages(
                        new String[]{"Ketchup", "Tangy BBQ", "Spicy Buffalo", "Creamy Chili", "Mayo", "Honey Mustard", "Sweet N' Sour"},
                        new double[]{10, 10, 10, 10, 10, 10, 10},
                        new String[]{
                                "k.png",
                                "tb.png",
                                "sb.png",
                                "cc.png",
                                "m.png",
                                "hm.png",
                                "ss.png"
                        }));

        menuPanel.add(tabbedPane, BorderLayout.CENTER);

        orderArea = new JTextArea();
        orderArea.setEditable(false);
        orderArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        orderArea.setBorder(BorderFactory.createTitledBorder("Your Order"));
        JScrollPane scrollPane = new JScrollPane(orderArea);
        scrollPane.setPreferredSize(new Dimension(580, 180));
        menuPanel.add(scrollPane, BorderLayout.SOUTH);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.setFont(new Font("Arial", Font.BOLD, 16));
        checkoutButton.setBackground(new Color(255, 69, 0));
        checkoutButton.setForeground(Color.WHITE);
        checkoutButton.setFocusPainted(false);
        checkoutButton.addActionListener(e -> processPayment());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(checkoutButton);
        menuPanel.add(bottomPanel, BorderLayout.PAGE_END);
    }

    private JPanel createCategoryPanelWithImages(String[] items, double[] prices, String[] imagePaths) {
        JPanel panel = new JPanel(new GridLayout(4, 3, 15, 15));

        for (int i = 0; i < items.length; i++) {
            String itemName = items[i];
            double itemPrice = prices[i];
            String imagePath = imagePaths[i];

            ImageIcon icon;
            try {
                icon = new ImageIcon(imagePath);
            } catch (Exception e) {
                icon = new ImageIcon(); // fallback
            }

            Image scaledImg = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImg);

            JButton itemButton = new JButton("<html><center>" + itemName + "<br>Php " + itemPrice + "</center></html>", scaledIcon);
            itemButton.setHorizontalTextPosition(SwingConstants.CENTER);
            itemButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            itemButton.setFocusPainted(false);
            itemButton.setBackground(Color.WHITE);
            itemButton.setPreferredSize(new Dimension(140, 140));

            itemButton.addActionListener(e -> {
                try {
                    String qtyStr = JOptionPane.showInputDialog(this, "Enter quantity for " + itemName + ":");
                    if (qtyStr != null && !qtyStr.trim().isEmpty()) {
                        int qty = Integer.parseInt(qtyStr.trim());
                        if (qty > 0) {
                            addItemToOrder(itemName, itemPrice, qty);
                        }
                    }
                } catch (NumberFormatException ignored) {}
            });

            panel.add(itemButton);
        }

        int emptySlots = 12 - items.length;
        for (int i = 0; i < emptySlots; i++) {
            panel.add(new JLabel());
        }

        return panel;
    }

    private void addItemToOrder(String item, double price, int quantity) {
        double subTotal = price * quantity;
        total += subTotal;

        orderArea.append(String.format("%-20s x%d  Php %.2f\n", item, quantity, subTotal));
        orderArea.append("-------------------------------\n");
        orderArea.append(String.format("Total:               Php %.2f\n\n", total));
    }

    private void processPayment() {
        if (total == 0) {
            JOptionPane.showMessageDialog(this, "No items ordered yet.", "Checkout", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        boolean validInput = false;
        double payment = 0.0;

        while (!validInput) {
            String input = JOptionPane.showInputDialog(this,
                    String.format("Your total is: Php %.2f\nPlease enter your payment amount:", total),
                    "Payment", JOptionPane.PLAIN_MESSAGE);

            if (input == null) return;

            try {
                payment = Double.parseDouble(input);
                if (payment >= total) {
                    validInput = true;
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Payment is less than total amount.",
                            "Insufficient Payment", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "Invalid input. Please enter a number.",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }

        double change = payment - total;

        StringBuilder receipt = new StringBuilder();
        receipt.append("===== McDonald's Receipt =====\n\n");
        receipt.append("==============================\n\n");
        receipt.append("\t\tMcDonald's Restaurant\n");
        receipt.append("\t\tBacarra Rd.\n\n");
        receipt.append(orderArea.getText());
        receipt.append(String.format("Total:     Php %.2f\n", total));
        receipt.append(String.format("Payment:   Php %.2f\n", payment));
        receipt.append(String.format("Change:    Php %.2f\n", change));
        receipt.append("\nThank you for your order!\n");
        receipt.append("For feedback: McDonalds.com\n");
        receipt.append("Or call/text: 0931-862-4169\n");
        receipt.append("==============================");

        JOptionPane.showMessageDialog(this, receipt.toString(), "Receipt", JOptionPane.INFORMATION_MESSAGE);

        total = 0.0;
        orderArea.setText("");
        orderArea.setCaretPosition(0); // scroll to top
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            McDonaldsMenu menu = new McDonaldsMenu();
            menu.setVisible(true);
        });
    }
}
