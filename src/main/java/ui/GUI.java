// package ui;

// import javax.swing.JFrame;
// import java.awt.Container;
// import java.awt.BorderLayout;
// import java.awt.GridLayout;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JLabel;
// import javax.swing.BoxLayout;
// import javax.swing.JButton;
// import javax.swing.JOptionPane;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeParseException;
// import javax.swing.JMenuBar;
// import javax.swing.JMenu;
// import javax.swing.JMenuItem;

// import todo.TodoList;
// import todo.Item;

// import java.io.IOException;

// import files.FileReader;
// import files.FileWriter;
// import files.FileFormatException;

// public class GUI extends JFrame{

//     private JPanel listPanel;
//     private TodoList list;

//     //window setup
//     public GUI(String windowTitle, int width, int height){
//         super(); //basic constructor
//         setTitle(windowTitle);
//         setSize(width, height);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         setJMenuBar(setupMenuBar());

//         list = new TodoList("My List");

//         list.addItem(new Item());
//         list.addItem(new Item());
//         list.addItem(new Item());
//         list.addItem(new Item());


//         Container contentPane = getContentPane();
//         contentPane.setLayout(new BorderLayout());

//         listPanel = new JPanel();
//         listPanel.setLayout(new GridLayout(0,5));

//         setUpListPanel(list);

//         JScrollPane scrollPane = new JScrollPane(listPanel);

//         contentPane.add(setUpActionPanel(), BorderLayout.EAST);
//         contentPane.add(scrollPane, BorderLayout.WEST);

//         refreshListPanel();

//         show(); //does painting
//     }

//     private void refreshListPanel(){
//         listPanel.removeAll();
//         setUpListPanel(list);

//         listPanel.repaint();
//         listPanel.revalidate();
//     }

//     private JMenuBar setupMenuBar(){
//         JMenuBar menuBar = new JMenuBar();

//         JMenu fileMenu = new JMenu("File");

//         JMenuItem saveItem = new JMenuItem("Save");
//         saveItem.addActionListener(event -> saveListOption());
//         fileMenu.add(saveItem);

//         JMenuItem loadItem = new JMenuItem("Load");
//         loadItem.addActionListener(event -> loadListOption());
//         fileMenu.add(loadItem);
        
//         menuBar.add(fileMenu);

//         return menuBar;

//     }




//     private JPanel setUpActionPanel(){

//         JPanel actionPanel = new JPanel();
//         actionPanel.setLayout(new BoxLayout(actionPanel, BoxLayout.PAGE_AXIS));
        
//         JButton addItemBtn = new JButton("Add New Item");
//         addItemBtn.addActionListener(event-> addItemOption());
//         actionPanel.add(addItemBtn);

//         JButton completeItemBtn = new JButton("Complete Item");
//         actionPanel.add(completeItemBtn);

//         return actionPanel;

//     }
    
//     public LocalDateTime getUserDateTime() throws Exception {
//         String dateString = JOptionPane.showInputDialog("Enter due date (YYYY/MM/DD)");
//         String timeString = JOptionPane.showInputDialog("Enter Due Time (HH/MM/SS)");

//         try {
//             LocalDateTime dateTime = LocalDateTime.parse(dateString + "T" + timeString);

//             return dateTime;
//         } catch (DateTimeParseException err) {
//             throw new Exception("Datetime is not valid: " + err.getMessage());
//         }
//     }

    
//     private void addItemOption(){

//         String title = JOptionPane.showInputDialog("Enter item title");
//         String desc = JOptionPane.showInputDialog("Enter item description");
//         LocalDateTime dueDateTime;
//         try {
//             dueDateTime = getUserDateTime();
//         } catch (Exception err) {
//             JOptionPane.showMessageDialog(this, err.getMessage() + " . default to now + 1 hour" , "date error", JOptionPane.ERROR_MESSAGE);
//             dueDateTime = LocalDateTime.now().plusHours(1);
//         }
//         int priority = 1;

//         list.addItem(title, desc, dueDateTime, priority);
//         refreshListPanel(); //refreshes after add
//     }

//     private void setUpListPanel(TodoList list){
//         for(Item  item : list){
//             listPanel.add(new JLabel(item.getTitle()));
//             listPanel.add(new JLabel(item.getDescription()));
//             listPanel.add(new JLabel(item.getDueDateTime().toString()));
//             listPanel.add(new JLabel(Integer.toString(item.getPriority())));
//             listPanel.add(new JLabel(item.getCompletedString()));
//         }
//     }

//     private void saveListOption() {
//         String saveFileName = JOptionPane.showInputDialog("Enter a file to save to");
//         FileWriter fw = new FileWriter(saveFileName);

//         fw.write(list);

//         for (Item item : list) {
//             fw.write(item);
//         }

//         try {
//             fw.save();
//         } catch (IOException err) {
//             JOptionPane.showMessageDialog(this, " Error writing to file" + saveFileName , "save error", JOptionPane.ERROR_MESSAGE);
//         }

//         JOptionPane.showMessageDialog(this, "saved file to" + fw.getFilePath(), "file saved", JOptionPane.ERROR_MESSAGE);
//     }

//     private void loadListOption() {

//         String saveFileName = JOptionPane.showInputDialog("input file to load from");

//         try {
//             FileReader fr = new FileReader(saveFileName);

//             String listTitle = fr.readLine();

//             TodoList newList = new TodoList(listTitle);

//             int numItems = fr.readInt();
//             for (int i = 0; i < numItems; i++) {
//                 String itemTitle = fr.readLine();
//                 String itemDesc = fr.readLine();
//                 LocalDateTime dueDate = fr.readDateTime();
//                 int priority = fr.readInt();
//                 boolean completed = fr.readBoolean();

//                 newList.addItem(itemTitle, itemDesc, dueDate, priority);

//                 if (completed) {
//                     newList.completeItem(newList.getIndexByTitle(itemTitle));
//                 }

//             }

//             this.list = newList;
//             refreshListPanel();

//         } catch (FileFormatException err) {
//             JOptionPane.showMessageDialog(this, "Incorrect format" + err.getMessage() , "Load Error", JOptionPane.ERROR_MESSAGE);
//         } catch (Exception err) {
//             JOptionPane.showMessageDialog(this,"Error" + err.getMessage(), " Load Error", JOptionPane.ERROR_MESSAGE);
//         }

//     }

//     public static void main(String[] args){
//         new GUI("TODO List", 900, 500);
//     }

// }