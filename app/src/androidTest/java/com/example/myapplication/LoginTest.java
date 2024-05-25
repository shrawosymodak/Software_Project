package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static org.junit.Assert.*;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class LoginTest {

    @Rule
//    public ActivityTestRule<Login> activityRule = new ActivityTestRule<>(LoginActivity.class);
    public ActivityScenarioRule<Login> activityRule = new ActivityScenarioRule<>(Login.class);

    @Test
    public void testwithoutLogin() {
        // Attempt to login without filling all fields
        onView(ViewMatchers.withId(R.id.login_button)).perform(ViewActions.click());
        onView(ViewMatchers.withText("Please Fill all the Fields"));
    }
    @Test
    public void testWithoutemail() {
        // Attempt to login without filling email
        onView(ViewMatchers.withId(R.id.emailLogin)).perform(ViewActions.typeText(""));
        onView(ViewMatchers.withText("Please Fill all the Fields"));
    }
    @Test
    public void testWithoutpassword() {
        // Attempt to login without filling password
        onView(ViewMatchers.withId(R.id.passwordLogin)).perform(ViewActions.typeText(""));
        onView(ViewMatchers.withText("Please Fill all the Fields"));
    }
    @Test
    public void testwithfieds(){
        // Attempt to login with all fields filled
        onView(ViewMatchers.withId(R.id.emailLogin)).perform(ViewActions.typeText("test"));
        onView(ViewMatchers.withId(R.id.passwordLogin)).perform(ViewActions.typeText("test"));
        onView(ViewMatchers.withId(R.id.login_button)).perform(ViewActions.click());
        onView(ViewMatchers.withText("Login Successfully"));
    }
}