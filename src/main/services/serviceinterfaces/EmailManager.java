package main.services.serviceinterfaces;

import main.modelpojos.Idea;

/**
 * Created by Armando on 11/23/2016.
 */
public interface EmailManager {


    void verifyEmail(Idea idea);
}
