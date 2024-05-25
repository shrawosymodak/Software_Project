package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static org.junit.Assert.*;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class SignUpTest {

    @Rule
    public ActivityScenarioRule<SignUp> activityRule = new ActivityScenarioRule<>(SignUp.class);

    @Test
    public void testwithoutSignUp() {
        // Attempt to sign up without filling all fields
        onView(ViewMatchers.withId(R.id.registration_button)).perform(ViewActions.click());
        onView(ViewMatchers.withText("Please Fill all the Fields"));
    }
    @Test
    public void testwithfieds() {
        // Attempt to sign up with all fields filled
        onView(ViewMatchers.withId(R.id.username_edit_text)).perform(ViewActions.typeText("test"));
        onView(ViewMatchers.withId(R.id.email_edit_text)).perform(ViewActions.typeText("test@gmail.com"));
        onView(ViewMatchers.withId(R.id.password_edit_text)).perform(ViewActions.typeText("test"));
        onView(ViewMatchers.withId(R.id.registration_button)).perform(ViewActions.click());
        onView(ViewMatchers.withText("Registered Successfully"));
    }
}