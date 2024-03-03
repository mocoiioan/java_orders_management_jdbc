package com.example.assignment3.Presentation;

/**
 * The type Main controller.
 */
public class MainController {
    private MainView mainView;

    /**
     * Instantiates a new Main controller.
     *
     * @param mainView the main view
     */
    public MainController(MainView mainView) {
        this.mainView = mainView;
    }

    /**
     * Gets main view.
     *
     * @return the main view
     */
    public MainView getMainView() {
        return mainView;
    }
}
