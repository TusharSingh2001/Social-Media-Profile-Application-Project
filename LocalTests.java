import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import java.net.Socket;
import java.util.ArrayList;

import static org.junit.Assert.fail;

/**
 * Purdue University -- CS18000 -- Fall 2020 -- Project 5
 * Test cases for Project 5
 * 1. OtherProfileGUI
 * 2. ProfileGUI
 * 3. client
 * 4. Profile
 * 5. Registration
 * 6. Server
 * 7. ProfileEditPage
 * 8. LoginPage
 */
public class LocalTests {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }

    /**
     * Test cases for OtherProfileGUI class
     *
     * @author Shruti Goyal
     * @version December 7th, 2020
     */

    public static class TestCase {
        private final PrintStream originalOutput = System.out;
        private final InputStream originalSysin = System.in;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayInputStream testIn;

        @SuppressWarnings("FieldCanBeLocal")
        private ByteArrayOutputStream testOut;

        @Before
        public void outputStart() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
        }

        @After
        public void restoreInputAndOutput() {
            System.setIn(originalSysin);
            System.setOut(originalOutput);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }

        /* Tests for OtherProfileGUI class */
        @Test(timeout = 1_000)
        public void OtherProfileGUIClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = OtherProfileGUI.class;
            className = "OtherProfileGUI";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `" + className + "` extends `JFrame`!", JFrame.class, superclass);

            Assert.assertEquals("Ensure that `" + className + "` implements ActionListener!", 1, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIContainerFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "container";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Container.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void myUsernameFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "myUsername";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void thisUsernameFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "thisUsername";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUINameLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "nameLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIUsernameLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "usernameLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUILikesLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "likesLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIBioLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "bioLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIBirthdayLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "birthdayLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIEmailLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIEducationLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "educationLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIUsernameTagLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "usernameTagLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUILikesTagLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "likesTagLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIBirthdayTagLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "birthdayTagLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIEmailTagLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailTagLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIEducationTagLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "educationTagLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void backButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "backButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void addFriendButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "addFriendButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void removeFriendButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "removeFriendButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUICancelFriendRequestButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "cancelFriendRequestButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIVertFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "vert";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JSeparator.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void otherProfileGUIHighlightFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "highlight";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JSeparator.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void OtherProfileGUIThisProfileFieldDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "thisProfile";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Profile.class;

            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void OtherProfileGUIParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 1;

            clazz = OtherProfileGUI.class;

            try {
                constructor = clazz.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has eight parameters with type String!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor throws 'IOException'!", expectedLength, exceptions.length);
        }

        @Test(timeout = 1000)
        public void OtherProfileGUISetValuesTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getValues";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, Profile.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has a parameter of type Profile!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void OtherProfileGUISetLocationAndSizeMethodTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setLocationAndSize";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void OtherProfileGUIStylingMethodTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "styling";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void OtherProfileGUIAddComponentsToContainerMethodTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "addComponentsToContainer";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        public void OtherProfileGUIAddActionMethodTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "addAction";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        public void OtherProfileGUIActionPerformedMethodTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "actionPerformed";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ActiveEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        public void OtherProfileGUIMainMethodTest() {
            Class<?> clazz;
            String className = "OtherProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "main";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = OtherProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws one exception", expectedLength, exceptions.length);

        }

        /**
         * Tests for class ProfileGUI
         *
         * @author Shruti Goyal
         */

        @Test(timeout = 1_000)
        public void profileGUIClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = ProfileGUI.class;
            className = "ProfileGUI";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `" + className + "` extends `JFrame`!", JFrame.class, superclass);

            Assert.assertEquals("Ensure that `" + className + "` implements ActionListener!", 1, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void profileGUIContainerFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "container";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Container.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void ProfileGUIFriendRequestsFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "friendRequests";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUINameLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "nameLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIUsernameLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "usernameLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUILikesLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "likesLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIBioLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "bioLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIBirthdayLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "birthdayLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIEmailLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIEducationLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "educationLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIUsernameTagLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "usernameTagLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUILikesTagLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "likesTagLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIBirthdayTagLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "birthdayTagLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIEmailTagLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailTagLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIEducationTagLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "educationTagLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void myFriendsFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "myFriends";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void allUsersLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "allUsersLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void refreshFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "refresh";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void editFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "edit";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void goToProfileButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "goToProfileButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIAcceptFriendRequestFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "acceptFriendRequest";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void declineFriendRequestFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "declineFriendRequest";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void logoutButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "logoutButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void searchFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "search";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIVertFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "vert";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JSeparator.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profileGUIHighlightFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "highlight";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JSeparator.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void friendsListFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "friendsList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JComboBox.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void friendRequestsListFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "friendRequestsList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JComboBox.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void allUserListFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "allUserList";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JComboBox.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void myProfileFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "myProfile";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Profile.class;

            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void profileGUIParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 1;

            clazz = ProfileGUI.class;

            try {
                constructor = clazz.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has ten parameters with type String!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor throws 'IOException'!", expectedLength, exceptions.length);
        }

        @Test(timeout = 1000)
        public void profileGUIGetValuesTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getValues";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, Profile.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has a parameter of type Profile!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws one exception!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileGUISetLocationAndSizeMethodTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setLocationAndSize";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileGUIStylingMethodTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "styling";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileGUIAddComponentsToContainerMethodTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "addComponentsToContainer";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        public void profileGUIAddActionMethodTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "addAction";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        public void profileGUIActionPerformedMethodTest() {
            Class<?> clazz;
            String className = "ProfileGUI";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "addAction";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = ProfileGUI.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ActiveEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        /**
         * Tests for class client
         *
         * @author Shruti Goyal
         */

        @Test(timeout = 1_000)
        public void clientClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = Client.class;
            className = "Client";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `" + className + "` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `" + className + "` implements no interfaces", 0, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void disFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "dis";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = DataInputStream.class;

            // Set the class being tested
            clazz = Client.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void dosFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Client";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "dos";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = DataOutputStream.class;

            // Set the class being tested
            clazz = Client.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        public void ClientMainMethodTest() {
            Class<?> clazz;
            String className = "Client";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "main";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Client.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws one exception", expectedLength, exceptions.length);

        }

        /**
         * Profile class testing
         *
         * @author Tushar Singh
         */

        @Test(timeout = 1_000)
        public void profileClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = Profile.class;
            className = "Profile";

            // Perform tests
            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `" + className + "` extends `Object`!", Object.class, superclass);

            Assert.assertEquals("Ensure that `" + className + "` implements no interfaces!", 0, superinterfaces.length);

        }

        @Test(timeout = 1_000)
        public void userNameFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "userName";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void realNameFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "realName";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void likesFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "likes";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void profilePasswordFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "password";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void bioFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "bio";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void birthdayFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "birthday";


            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void profileEmailFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "email";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void educationFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Profile";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "education";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void friendsFieldDeclaration() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "friends";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ArrayList.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void ProfileFriendRequestsFieldDeclarationTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "friendRequests";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = ArrayList.class;


            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + fieldName + "` field is `private`!", Modifier.isPrivate(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        /*   All fields testing completed!  */


        /* All string get methods  */


        @Test(timeout = 1000)
        public void profileGetUserNameMethodTest() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getUserName";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }


        @Test(timeout = 1000)
        public void profileGetRealNameMethodTest() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getRealName";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileGetLikesMethodTest() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getLikes";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileGetBioMethodTest() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getBio";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileGetBirthdayMethodTest() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getBirthday";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileGetEmailMethodTest() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getEmail";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileGetEducationMethodTest() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getEducation";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }


        @Test(timeout = 1000)
        public void profileGetPasswordMethodTest() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getPassword";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = String.class;


            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        /*  All String get methods testing completed!  */



        /*  All string set methods testing completed!  */

        @Test(timeout = 1000)
        public void profileSetUserNameMethodTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setUserName";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type String!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileSetRealNameMethodTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setRealName";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type String!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileSetLikesMethodTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setLikes";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type String!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileSetBioMethodTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setBio";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type String!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileSetBirthdayMethodTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setBirthday";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type String!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        @Test(timeout = 1000)
        public void profileSetEmailMethodTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setEmail";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type String!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }


        @Test(timeout = 1000)
        public void profileSetEducationMethodTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setEducation";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type String!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }


        @Test(timeout = 1000)
        public void profileSetPasswordMethodTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setPassword";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type String!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        /*  All String set methods testing completed!   */



        /*  All arraylist get methods testing starts   */

        @Test(timeout = 1000)
        public void profileGetFriendsMethodTest() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getFriends";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = ArrayList.class;


            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }


        @Test(timeout = 1000)
        public void profileGetFriendRequestsMethodTest() {
            Class<?> clazz;
            String className = "Profile";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "getFriendRequests";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = ArrayList.class;


            // Set the class being tested
            clazz = Profile.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        /* All arraylist get method testing completed!   */


        /*  All arraylist set method testing starts!   */

        @Test(timeout = 1000)
        public void profileSetFriendsMethodTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setFriends";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ArrayList.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type Arraylist!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }


        @Test(timeout = 1000)
        public void profileSetFriendRequestsMethodTest() {

            Class<?> clazz = Profile.class;
            String className = "Profile";

            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setFriendRequests";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ArrayList.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter of type Arraylist!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }


        /*  Constructor testings starts!   */


        @Test(timeout = 1_000)
        public void profileParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "Profile";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = Profile.class;

            try {
                constructor = clazz.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class,
                        String.class, String.class, String.class, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has ten parameters with type String!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor has an empty `throws` clause!",
                    expectedLength, exceptions.length);
        }

        /**
         * tests for registration class
         *
         * @author Digvijay pawar
         */

        @Test(timeout = 1_000)
        public void registrationClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = Registration.class;
            className = "Registration";

            // Perform tests
            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `" + className + "` extends `JFrame`!", javax.swing.JFrame.class, superclass);

            Assert.assertEquals("Ensure that `" + className + "` implements no interfaces!", 1, superinterfaces.length);

        }

        @Test(timeout = 1_000)
        public void RegistrationUsernameFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "username";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void registrationPasswordFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "password";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();


            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void registrationEmailFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "email";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void RegistrationUsernameLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "usernameL";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void registrationPasswordLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "passwordL";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void RegistrationEmailLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailL";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void confirmButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "confirmButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void registrationLoginButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "loginButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void registrationNoArgConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = Registration.class;

            try {
                constructor = clazz.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has 0 parameters!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s constructor throws no exceptions", expectedLength, exceptions.length);
        }


        @Test(timeout = 1000)
        public void SetComponentSizeTest() {
            Class<?> clazz;
            String className = "Registration";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "setComponentSize";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

        }


        @Test(timeout = 1000)
        public void addComponentTest() {
            Class<?> clazz;
            String className = "Registration";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "addComponents";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

        }


        public void registrationAddActionMethodTest() {
            Class<?> clazz;
            String className = "Registration";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "addAction";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);


        }

        public void registrationActionPerformedMethodTest() {
            Class<?> clazz;
            String className = "Registration";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "actionPerformed";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ActiveEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);


        }


        public void RegistrationMainMethodTest() {
            Class<?> clazz;
            String className = "Registration";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "main";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);


        }

        public void registrationRunRegistrationMethodTest() {
            Class<?> clazz;
            String className = "Registration";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "runRegistration";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);


        }


        @Test(timeout = 1_000)
        public void RegistrationEmailTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailT";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        public void RegistrationPasswordTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "passwordT";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        public void RegistrationUsernameTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "usernameT";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void registrationContainerFieldDeclarationTest() {
            Class<?> clazz;
            String className = "Registration";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "container";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Container.class;

            // Set the class being tested
            clazz = Registration.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        /**
         * Tests for the Server class
         *
         * @author Shruti Goyal
         */

        @Test(timeout = 1_000)
        public void serverClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = Server.class;
            className = "Server";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `" + className + "` extends `Thread`!", Thread.class, superclass);

            Assert.assertEquals("Ensure that `" + className + "` implements Runnable!", 1, superinterfaces.length);
        }

        public void ServerMainMethodTest() {
            Class<?> clazz;
            String className = "Server";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "main";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = Server.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws one exception", expectedLength, exceptions.length);

        }

        /**
         * Test cases for the ProfileEditPage class
         *
         * @author Tushar Singh
         */

        @Test(timeout = 1_000)
        public void profileEditPageClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = ProfileEditPage.class;
            className = "ProfileEditPage";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `" + className + "` extends `JFrame`!", JFrame.class, superclass);

            Assert.assertEquals("Ensure that `" + className + "` implements ActionListener!", 1, superinterfaces.length);
        }


        /*   Testing for JLabels starts!   */

        @Test(timeout = 1_000)
        public void ProfileEditEmailLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        /*   Testing for JLabels starts!   */

        @Test(timeout = 1_000)
        public void birthdayLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "birthdayLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        /*   Testing for JLabels starts!   */

        @Test(timeout = 1_000)
        public void bioLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "bioLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        /*   Testing for JLabels starts!   */

        @Test(timeout = 1_000)
        public void educationLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "educationLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        /*   Testing for JLabels starts!   */

        @Test(timeout = 1_000)
        public void likesLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "likesLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        /*   Testing for JLabels starts!   */

        @Test(timeout = 1_000)
        public void nameLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "nameLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        /*  Testing for JLables ends!  */


        /*  Testing for JTextField starts!  */

        @Test(timeout = 1_000)
        public void ProfileEditEmailTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "emailText";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void birthdayTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "birthdayText";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void bioTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "bioText";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void educationTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "educationText";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void likesTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "likesText";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void nameTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "nameText";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        /*   Testing for JTextField ends!   */


        /*   Testing for JButtton starts!   */

        @Test(timeout = 1_000)
        public void confirmButtonDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "confirmButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void deleteButtonDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "deleteButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        /*   Container Field Test Case  */



        /*   Constructor Test case   */

        @Test(timeout = 1_000)
        public void profileEditPageParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 1;

            clazz = ProfileEditPage.class;

            try {
                constructor = clazz.getDeclaredConstructor(Profile.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has parameter of type Profile!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

        }

        public void profileEditPageActionPerformedMethodTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "actionPerformed";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ActiveEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        /* Work method test cases */

        public void profileEditPageWorkMethodTest() {
            Class<?> clazz;
            String className = "ProfileEditPage";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "work";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = ProfileEditPage.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has an empty `throws` clause!", expectedLength, exceptions.length);

        }

        /**
         * Tests for the LoginPage class
         *
         * @author Digvijay Pawar
         */

        @Test(timeout = 1_000)
        public void LoginPageClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = LoginPage.class;
            className = "LoginPage";

            // Perform tests
            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `" + className + "` extends `JFrame`!", JFrame.class, superclass);

            Assert.assertEquals("Ensure that `" + className + "` implements 'ActionListener'!", 1, superinterfaces.length);

        }

        @Test(timeout = 1_000)
        public void loginPageUsernameFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "username";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();


            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void passwordFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "password";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = String.class;

            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();


            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void loginPageUsernameLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "usernameLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void loginPagePasswordLabelFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "passwordLabel";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JLabel.class;

            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void LoginPageLoginButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "loginButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void RegisterButtonFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "registerButton";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JButton.class;

            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void LoginPageNoArgConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 1;

            clazz = LoginPage.class;

            try {
                constructor = clazz.getDeclaredConstructor();
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has 0 parameters!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s constructor is `public`!", Modifier.isPublic(modifiers));

        }

        public void LoginPageActionPerformedMethodTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "actionPerformed";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, ActiveEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

        }


        public void LoginPageMainMethodTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "main";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;


            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has one parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

        }


        public void loginPagePasswordTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "passwordText";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        public void loginpageUsernameTextFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "usernameText";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = JTextField.class;

            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void loginPageontainerFieldDeclarationTest() {
            Class<?> clazz;
            String className = "LoginPage";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "container";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Container.class;

            // Set the class being tested
            clazz = LoginPage.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }
        /**
         *
         * Test cases for ClientHandler class
         *
         **/
        @Test(timeout = 1_000)
        public void clientHandlerClassDeclarationTest() {
            Class<?> clazz;
            String className;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            // Set the class being tested
            clazz = ClientHandler.class;
            className = "ClientHandler";

            // Perform tests

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `" + className + "` is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "` is NOT `abstract`!", Modifier.isAbstract(modifiers));

            Assert.assertEquals("Ensure that `" + className + "` extends `Thread`!", Thread.class, superclass);

            Assert.assertEquals("Ensure that `" + className + "` implements No Interface!", 0, superinterfaces.length);
        }

        @Test(timeout = 1_000)
        public void clientHandlerSFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "s";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = Socket.class;

            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void clientHandlerDosFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "dos";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = DataOutputStream.class;

            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }

        @Test(timeout = 1_000)
        public void clientHandlerDisFieldDeclarationTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Field testField;
            int modifiers;
            Class<?> type;

            // Set the field that you want to test
            String fieldName = "dis";

            // Set the type of the field you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedType = DataInputStream.class;

            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class field
            try {
                testField = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                Assert.fail("Ensure that `" + className + "` declares a field named `" + fieldName + "`!");

                return;
            } //end try catch

            // Perform tests

            modifiers = testField.getModifiers();

            type = testField.getType();

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `final`!", Modifier.isFinal(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + fieldName + "` field is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + fieldName + "` field is the correct type!", expectedType, type);
        }


        @Test(timeout = 1_000)
        public void ClientHandlerParameterizedConstructorDeclarationTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Constructor<?> constructor;
            int modifiers;
            Class<?>[] exceptions;
            int expectedLength = 0;

            clazz = ClientHandler.class;

            try {
                constructor = clazz.getDeclaredConstructor(Socket.class, DataOutputStream.class, DataInputStream.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a constructor that is `public` and has eight parameters with type String!");

                return;
            } //end try catch

            modifiers = constructor.getModifiers();

            exceptions = constructor.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s parameterized constructor is `public`!", Modifier.isPublic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s parameterized constructor throws 'no Exception'!", expectedLength, exceptions.length);
        }

        @Test(timeout = 1000)
        public void ClientHandlerRunTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "run";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has no parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is synchronized!", Modifier.isSynchronized(modifiers));

        }

        @Test(timeout = 1000)
        public void ClientHandlerDeleteProfileTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 1;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "deleteProfile";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws IOException!", expectedLength, exceptions.length);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is synchronized!", Modifier.isSynchronized(modifiers));

        }

        @Test(timeout = 1000)
        public void ClientHandlerRemoveFriendTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "removeFriend";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 2 parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is synchronized!", Modifier.isSynchronized(modifiers));

        }

        @Test(timeout = 1000)
        public void ClientHandlerAddFriendTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "addFriend";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 2 parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is synchronized!", Modifier.isSynchronized(modifiers));

        }

        @Test(timeout = 1000)
        public void ClientHandlerCheckFriendRequestsTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "checkFriendRequests";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 2 parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is synchronized!", Modifier.isSynchronized(modifiers));

        }

        @Test(timeout = 1000)
        public void ClientHandlerCheckFriendsTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "checkFriends";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = boolean.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 2 parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is synchronized!", Modifier.isSynchronized(modifiers));

        }

        @Test(timeout = 1000)
        public void ClientHandlerRemoveFriendRequestTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "removeFriendRequest";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 2 parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is synchronized!", Modifier.isSynchronized(modifiers));

        }

        @Test(timeout = 1000)
        public void ClientHandlerSendFriendRequestTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "sendFriendRequest";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 2 parameters!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is synchronized!", Modifier.isSynchronized(modifiers));

        }

        @Test(timeout = 1000)
        public void ClientHandlerUpdateUsernameTest() {
            Class<?> clazz;
            String className = "ClientHandler";
            Method method;
            int modifiers;
            Class<?> actualReturnType;
            int expectedLength = 0;
            Class<?>[] exceptions;

            // Set the method that you want to test
            String methodName = "updateUsername";

            // Set the return type of the method you want to test
            // Use the type + .class
            // For example, String.class or int.class
            Class<?> expectedReturnType = void.class;
            Class<?>[] expectedExceptions;


            // Set the class being tested
            clazz = ClientHandler.class;

            // Attempt to access the class method
            try {
                method = clazz.getDeclaredMethod(methodName, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("Ensure that `" + className + "` declares a method named `" + methodName + "` that" +
                        " has 1 parameter!");

                return;
            } //end try catch

            // Perform tests

            modifiers = method.getModifiers();

            actualReturnType = method.getReturnType();

            exceptions = method.getExceptionTypes();

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is `public`!", Modifier.isPublic(modifiers));

            Assert.assertFalse("Ensure that `" + className + "`'s `" + methodName + "` method is NOT `static`!", Modifier.isStatic(modifiers));

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method has the correct return type!", expectedReturnType, actualReturnType);

            Assert.assertEquals("Ensure that `" + className + "`'s `" + methodName + "` method throws no exceptions!", expectedLength, exceptions.length);

            Assert.assertTrue("Ensure that `" + className + "`'s `" + methodName + "` method is synchronized!", Modifier.isSynchronized(modifiers));

        }
    }
}
