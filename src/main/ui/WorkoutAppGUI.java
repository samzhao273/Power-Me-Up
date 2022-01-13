package ui;

import model.*;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Event;
import persistence.JsonReader;
import persistence.JsonWriter;


import java.io.FileNotFoundException;
import java.io.IOException;

public class WorkoutAppGUI {
    private JFrame frame;
    private JPanel panel = new JPanel();
    private JPanel addWorkoutPanel = new JPanel();
    private Workouts yourWorkouts;
    private JButton addWorkoutButton = new JButton("Add Workout");
    private JButton viewWorkoutsButton = new JButton("View Workouts");
    private JButton getWorkoutButton = new JButton("Get a Workout");
    private JButton viewProfileButton = new JButton("View my Profile");
    private JButton editProfileButton = new JButton("Edit my Profile");
    private JButton saveWorkoutsButton = new JButton("Save My Workouts");
    private JButton loadWorkoutsButton = new JButton("Load my Workouts");
    private JButton saveMyProfileButton = new JButton("Save my Profile");
    private JButton loadMyProfileButton = new JButton("Load my Profile");
    private JButton submitWorkout = new JButton("Add Workout");
    private JButton showWorkoutDetails = new JButton("Get Workout");
    private JButton quitApplication = new JButton("Quit");
    private JTextField nameTextField = new JTextField(20);
    private JTextField dateTextField = new JTextField(20);
    private JTextField durationTextField = new JTextField(20);
    private JTextField caloriesTextField = new JTextField(20);
    private JTextField typeTextField = new JTextField(20);
    private JTextField weightTextField = new JTextField(20);
    private JTextField setsTextField = new JTextField(20);
    private JTextField repsTextField = new JTextField(20);
    private JTextField locationTextField = new JTextField(20);
    private JTextField descriptionTextField = new JTextField(20);
    private JTextField favouriteTextField = new JTextField(20);
    private JTextField getWorkoutTextField = new JTextField(20);
    private JsonWriter jsonWriterWorkouts;
    private JsonReader jsonReaderWorkouts;
    private JsonWriter jsonWriterProfile;
    private JsonReader jsonReaderProfile;
    public static final String DATA_WORKOUTS_JSON = "./data/workouts.json";
    public static final String DATA_PROFILE_JSON = "./data/profile.json";
    private JLabel nameLabel = new JLabel("Enter the  Name");
    private JLabel dateLabel = new JLabel("Enter the  Date ");
    private JLabel durationLabel = new JLabel(" Enter Duration ");
    private JLabel caloriesLabel = new JLabel("Calories Burned");
    private JLabel typeLabel = new JLabel("Workout Type");
    private JLabel weightLabel = new JLabel("Weight Used ");
    private JLabel setsLabel = new JLabel("Number of Sets");
    private JLabel repsLabel = new JLabel("Number of Reps");
    private JLabel locationLabel = new JLabel("Workout Location");
    private JLabel descriptionLabel = new JLabel("Describe Workout");
    private JLabel favouriteLabel = new JLabel("Favourite??      ");
    private Profile profile;
    private JFrame editFrame;
    private JPanel editProfilePanel = new JPanel();
    private JLabel profileNameLabel = new JLabel("Enter Your Name: ");
    private JLabel dateOfBirthLabel = new JLabel("Enter Your DOB(MMDDYY): ");
    private JLabel ageLabel = new JLabel("Enter Your Age: ");
    private JLabel heightLabel = new JLabel("Enter Your Height(cm): ");
    private JLabel profileWeightLabel = new JLabel("Enter Your Weight(lbs): ");
    private JLabel benchMaxLabel = new JLabel("Enter Your BenchMax(lbs): ");
    private JLabel deadliftMaxLabel = new JLabel("Enter Your DeadliftMax(lbs): ");
    private JLabel squatMaxLabel = new JLabel("Enter Your SquatMax: ");
    private JTextField profileNameTextField = new JTextField(20);
    private JTextField dateOfBirthTextField = new JTextField(20);
    private JTextField ageTextField = new JTextField(20);
    private JTextField heightTextField = new JTextField(20);
    private JTextField profileWeightTextField = new JTextField(20);
    private JTextField benchMaxTextField = new JTextField(20);
    private JTextField deadliftMaxTextField = new JTextField(20);
    private JTextField squatMaxTextField = new JTextField(20);
    private JButton editNewProfileButton = new JButton("Edit Profile");


    //Creates a new WorkoutAppGUI
    public WorkoutAppGUI() {
        init();
        makeSplashScreen();
        frame = new JFrame();
        frame.setTitle("!!!Power Me Up!!!!");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(300, 400);
        frame.add(createPanel(), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    //MODIFIES: yourWorkouts
    //EFFECTS: initializes a new Workouts with name "Your Workouts"
    public void init() {
        yourWorkouts = new Workouts("Your Workouts");
        profile = new Profile("", 000000, 00,
                000, 000, 000, 000, 000);

    }


    //EFFECTS: Creates a new JPanel that has all the user story buttons
    public JPanel createPanel() {
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(addWorkoutButton);
        panel.add(viewWorkoutsButton);
        panel.add(getWorkoutButton);
        panel.add(viewProfileButton);
        panel.add(editProfileButton);
        panel.add(saveWorkoutsButton);
        panel.add(loadWorkoutsButton);
        panel.add(saveMyProfileButton);
        panel.add(loadMyProfileButton);
        panel.add(quitApplication);
        addWorkoutButton.addActionListener(new AddListener());
        viewWorkoutsButton.addActionListener(new ViewListener());
        getWorkoutButton.addActionListener(new GetListener());
        saveWorkoutsButton.addActionListener(new SaveWorkoutsListener());
        loadWorkoutsButton.addActionListener(new LoadWorkoutsListener());
        quitApplication.addActionListener(new QuitListener());
        viewProfileButton.addActionListener(new ViewProfileListener());
        editProfileButton.addActionListener(new EditProfileListener());
        saveMyProfileButton.addActionListener(new SaveProfileListener());
        loadMyProfileButton.addActionListener(new LoadProfileListener());
        return panel;

    }

    //EFFECTS: Creates a new JFrame that holds the add workout function Panel and functionality
    public void createWorkoutWindow() {
        JFrame addWorkoutFrame = new JFrame();
        addWorkoutFrame.setTitle("Add a Workout");
        addWorkoutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWorkoutFrame.setSize(400, 350);
        addWorkoutFrame.setResizable(false);
        addWorkoutFrame.setVisible(true);
        addComponentsToWorkoutPanel(addWorkoutPanel);
        addWorkoutFrame.add(addWorkoutPanel, BorderLayout.CENTER);
    }

    //EFFECTS: Creates a new JFrame that holds the get Workout Panel and functionality
    public void getWorkoutWindow() {
        JFrame getWorkoutFrame = new JFrame();
        getWorkoutFrame.setTitle("Get Workout");
        getWorkoutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getWorkoutFrame.setResizable(false);
        getWorkoutFrame.setSize(400, 100);
        getWorkoutFrame.setVisible(true);
        getWorkoutFrame.add(createGetWorkoutPanel(), BorderLayout.CENTER);

    }

    //Modifies: addWorkoutPanel
    //EFFECTS:  Adds JComponents to the addWorkoutPanel
    public void addComponentsToWorkoutPanel(JPanel addWorkoutPanel) {
        addWorkoutPanel.add(nameLabel);
        addWorkoutPanel.add(nameTextField);
        addWorkoutPanel.add(dateLabel);
        addWorkoutPanel.add(dateTextField);
        addWorkoutPanel.add(durationLabel);
        addWorkoutPanel.add(durationTextField);
        addWorkoutPanel.add(caloriesLabel);
        addWorkoutPanel.add(caloriesTextField);
        addWorkoutPanel.add(typeLabel);
        addWorkoutPanel.add(typeTextField);
        addWorkoutPanel.add(weightLabel);
        addWorkoutPanel.add(weightTextField);
        addWorkoutPanel.add(setsLabel);
        addWorkoutPanel.add(setsTextField);
        addWorkoutPanel.add(repsLabel);
        addWorkoutPanel.add(repsTextField);
        addWorkoutPanel.add(locationLabel);
        addWorkoutPanel.add(locationTextField);
        addWorkoutPanel.add(descriptionLabel);
        addWorkoutPanel.add(descriptionTextField);
        addWorkoutPanel.add(favouriteLabel);
        addWorkoutPanel.add(favouriteTextField);
        addWorkoutPanel.add(addWorkoutButton());
    }

    //MODIFIES: getWorkoutPanel
    //EFFECTS: Creates a new JPanel for the getWorkout frame and adds the JComponents to the panel
    public JPanel createGetWorkoutPanel() {
        JPanel getWorkoutPanel = new JPanel();
        JLabel l1 = new JLabel("Enter Name of Workout");
        getWorkoutPanel.add(l1);
        getWorkoutPanel.add(getWorkoutTextField);
        getWorkoutPanel.add(showWorkoutDetails);
        showWorkoutDetails.addActionListener(new GetWorkoutListener());
        return getWorkoutPanel;
    }

    //MODIFIES: submitWorkoutButton
    //EFFECTS: Adds a new Action Listener of Submit listener to the submitWorkout button
    public JButton addWorkoutButton() {
        submitWorkout.addActionListener(new SubmitListener());
        return submitWorkout;

    }

    //EFFECTS: saves Your Workouts to file
    private void saveWorkouts() {
        jsonWriterWorkouts = new JsonWriter(DATA_WORKOUTS_JSON);
        try {
            jsonWriterWorkouts.open();
            jsonWriterWorkouts.writeWorkouts(yourWorkouts);
            jsonWriterWorkouts.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save file to" + DATA_WORKOUTS_JSON);
        }
    }

    //MODIFIES: yourWorkouts
    //EFFECTS: Loads workouts from file
    private void loadWorkouts() {
        jsonReaderWorkouts = new JsonReader(DATA_WORKOUTS_JSON);
        try {
            yourWorkouts = jsonReaderWorkouts.readWorkouts();
        } catch (IOException e) {
            System.out.println("Unable to load from file" + DATA_WORKOUTS_JSON);
        }
    }


    //EFFECTS: saves Profile to file
    private void saveProfile() {
        jsonWriterProfile = new JsonWriter(DATA_PROFILE_JSON);
        try {
            jsonWriterProfile.open();
            jsonWriterProfile.writeProfile(profile);
            jsonWriterProfile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save file to" + DATA_PROFILE_JSON);
        }
    }

    //EFFECTS: Loads Profile from file
    private void loadProfile() {
        jsonReaderProfile = new JsonReader(DATA_PROFILE_JSON);
        try {
            profile = jsonReaderProfile.readProfile();
        } catch (IOException e) {
            System.out.println("Unable to load from file" + DATA_PROFILE_JSON);
        }
    }


    //Effects: return the list of names in the workouts in a string - list format
    public String showWorkouts() {
        return yourWorkouts.showWorkouts();
    }

    // Creates an action that saves your workouts to your JSon File
    class SaveWorkoutsListener implements ActionListener {
        @Override

        //EFFECTS: If the saveWorkoutsButton is pressed, Calls method saveWorkouts()
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == saveWorkoutsButton) {
                saveWorkouts();
            }
        }
    }

    // Creates an action that loads your workouts from the JSon File
    class LoadWorkoutsListener implements ActionListener {

        @Override
        //EFFECTS: If the loadWorkoutsButton is pressed, calls method loadWorkouts()
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loadWorkoutsButton) {
                loadWorkouts();
            }
        }
    }

    // Creates an action that opens a new add workout window;
    class AddListener implements ActionListener {
        @Override
        //EFFECTS: If the addWorkoutButton is pressed, calls method createWorkoutWindow()
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addWorkoutButton) {
                createWorkoutWindow();


            }
        }
    }

    // Creates an action  opens a message dialogue that shows a lis of workout names
    class ViewListener implements ActionListener {
        @Override
        //EFFECTS: When the view Workouts button is pressed,
        //         Opens a message dialog with a list of names of the workouts in yourWorkouts
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewWorkoutsButton) {
                JOptionPane.showMessageDialog(null, showWorkouts(),
                        "Your Workouts", 1);
            }
        }
    }

    // Creates an action that opens a get Workouts Window
    class GetListener implements ActionListener {
        @Override
        //EFFECTS: When the getWorkoutButton is pressed, call the method getWorkoutWindow()
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == getWorkoutButton) {
                getWorkoutWindow();

            }
        }
    }

    // Creates an action that adds a Workout to the yourWorkouts list;
    class SubmitListener implements ActionListener {
        @Override
        //REQUIRES: Two workouts cannot be same name, if done, only most recent workout will be returned
        //MODIFIES: yourWorkouts
        //EFFECTS: When the submitWorkout is pressed, create a new workout with the data in the text fields,
        //         and then add the workout to yourWorkouts
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitWorkout) {
                Workout addedWorkout = new Workout(nameTextField.getText(), Integer.parseInt(dateTextField.getText()),
                        Integer.parseInt(durationTextField.getText()), Integer.parseInt(caloriesTextField.getText()),
                        typeTextField.getText(), Integer.parseInt(weightTextField.getText()),
                        Integer.parseInt(setsTextField.getText()),
                        Integer.parseInt(repsTextField.getText()), locationTextField.getText(),
                        descriptionTextField.getText(), Boolean.parseBoolean(favouriteTextField.getText()));
                yourWorkouts.addWorkout(addedWorkout);
            }
        }
    }

    //Creates an action that opens a message Dialog
    class GetWorkoutListener implements ActionListener {
        @Override
        //EFFECTS: When the show workout details button is pressed
        //         open a message dialog that shows the details of a workout
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == showWorkoutDetails) {
                JOptionPane.showMessageDialog(null, showWorkoutDetails(), "Workout:" + " "
                        + showNameDetails(), 1);
            }
        }
    }

    //EFFECTS: Return the name of the workout that was desired from the text field
    public String showNameDetails() {
        String getWorkoutTextFieldValue = getWorkoutTextField.getText();
        for (Workout w : yourWorkouts.getWl()) {
            if (w.getName().equals(getWorkoutTextFieldValue)) {
                return w.getName();
            }
        }
        return "";
    }

    //Creates an action that quits the application
    class QuitListener implements ActionListener {

        @Override
        //EFFECTS: Calls the printLog method and exits the application
        public void actionPerformed(ActionEvent e) {
            printLog();
            System.exit(0);


        }
    }

    //Creates an action that views the Users Profile
    class ViewProfileListener implements ActionListener {

        @Override
        //EFFECTS: Calls the view Profile method and shows it in message screen
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, profile.showProfileDetails(),
                    "Profile: " + profile.getFullName(), 1);
        }
    }

    //Creates an action that allows the User to Edit the Profile
    class EditProfileListener implements ActionListener {
        @Override
        // Opens a new Window to edit your Profile
        public void actionPerformed(ActionEvent e) {
            editFrame = new JFrame();
            editFrame.setTitle("Edit Your Profile");
            editFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            editFrame.setSize(450, 300);
            editFrame.setResizable(false);
            editFrame.setVisible(true);
            addComponentsToEditPanel(editProfilePanel);
            editFrame.add(editProfilePanel, BorderLayout.CENTER);


        }
    }

    //Creates an action that allows the user to submit their new profile
    class EditNewProfileListener implements ActionListener {
        @Override
        // If editNewProfile button is pressed, change your profile to the profile you edited
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == editNewProfileButton) {
                profile = new Profile(
                        profileNameTextField.getText(),
                        Integer.parseInt(dateOfBirthTextField.getText()),
                        Integer.parseInt(ageTextField.getText()),
                        Integer.parseInt(heightTextField.getText()),
                        Integer.parseInt(profileWeightTextField.getText()),
                        Integer.parseInt(benchMaxTextField.getText()),
                        Integer.parseInt(deadliftMaxTextField.getText()),
                        Integer.parseInt(squatMaxTextField.getText())
                );
            }
        }
    }

    //Creates an action that saves your Profile
    class SaveProfileListener implements ActionListener {

        @Override
        //Effects: calls saveProfile method
        public void actionPerformed(ActionEvent e) {
            saveProfile();
        }
    }

    //Creates an action that loads your Profile
    class LoadProfileListener implements ActionListener {

        @Override
        //Effects: calls loadProfile method
        public void actionPerformed(ActionEvent e) {
            loadProfile();

        }
    }

    //EFFECTS: Adds components to the editProfilePanel
    public void addComponentsToEditPanel(JPanel editProfilePanel) {
        editProfilePanel.add(profileNameLabel);
        editProfilePanel.add(profileNameTextField);
        editProfilePanel.add(dateOfBirthLabel);
        editProfilePanel.add(dateOfBirthTextField);
        editProfilePanel.add(ageLabel);
        editProfilePanel.add(ageTextField);
        editProfilePanel.add(heightLabel);
        editProfilePanel.add(heightTextField);
        editProfilePanel.add(profileWeightLabel);
        editProfilePanel.add(profileWeightTextField);
        editProfilePanel.add(benchMaxLabel);
        editProfilePanel.add(benchMaxTextField);
        editProfilePanel.add(deadliftMaxLabel);
        editProfilePanel.add(deadliftMaxTextField);
        editProfilePanel.add(squatMaxLabel);
        editProfilePanel.add(squatMaxTextField);
        editNewProfileButton.addActionListener(new EditNewProfileListener());
        editProfilePanel.add(editNewProfileButton);


    }


    //EFFECTS: if the workout name equals the data in the text field, return the workout details in string-list format
    public String showWorkoutDetails() {
        String s = "";
        String getWorkoutTextFieldValue = getWorkoutTextField.getText();
        for (Workout w : yourWorkouts.getWl()) {
            if (w.getName().equals(getWorkoutTextFieldValue)) {
                s += w.showWorkoutDetails(w);
                break;
            }
        }
        return s;
    }


    //EFFECTS: Creates a splash screen with image before startup of workout app
    public void makeSplashScreen() {
        JWindow window = new JWindow();
        ImageIcon icon = new ImageIcon("KermitFinal.jpg");
        JLabel label = new JLabel(icon, SwingConstants.CENTER);
        window.getContentPane().add(label);
        window.setBounds(0, 0, 850, 870);
        window.setVisible(true);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        window.setVisible(false);
        window.dispose();
    }


    //EFFECTS: Prints the Log of Events
    public void printLog() {
        for (Event e : EventLog.getInstance()) {
            System.out.println(e);
        }
    }
}