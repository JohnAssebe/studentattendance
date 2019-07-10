package com.example.Attendance

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class StudentInfoValidatorUnitTest {

    class LoginValidatorUnitTest {
        //First name
        @Test
        fun firstName_CorrectFirstNameSimple_ReturnsTrue() {
            assertTrue(StudentValidator.isFirstNameInfoValid("johnny"))
        }

        @Test
        fun firstNameValidator_StartWith_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isFirstNameInfoValid("123john"))
        }

        @Test
        fun firstNameValidator_EndsWith_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isFirstNameInfoValid("john123"))
        }

        @Test
        fun firstNameValidator_InvalidFirstName_LessThan_Six_Character_ReturnsFalse() {
            assertFalse(StudentValidator.isFirstNameInfoValid("john"))
        }

        @Test
        fun firstNameValidator_InvalidFirstName_All_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isFirstNameInfoValid("123456"))
        }
        //Lasr Name

        @Test
        fun lastName_CorrectLastNameSimple_ReturnsTrue() {
            assertTrue(StudentValidator.isLastNameInfoValid("johnny"))
        }

        @Test
        fun lastNameValidator_StartWith_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isLastNameInfoValid("123john"))
        }

        @Test
        fun lastNameValidator_EndsWith_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isLastNameInfoValid("john123"))
        }

        @Test
        fun lastNameValidator_InvalidLastName_LessThan_Six_Character_ReturnsFalse() {
            assertFalse(StudentValidator.isLastNameInfoValid("john"))
        }

        @Test
        fun lastNameValidator_InvalidLastName_All_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isLastNameInfoValid("123456"))
        }

        //Course
        @Test
        fun courseNameValidator_CorrectCourseSimple_ReturnsTrue() {
            assertTrue(StudentValidator.isCourseNameIsValid("Android"))
        }

        @Test
        fun courseNameValidator_StartWith_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isCourseNameIsValid("123android"))
        }

        @Test
        fun courseNameValidator_EndsWith_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isCourseNameIsValid("Android123"))
        }

        @Test
        fun courseNameValidator_InvalidCourseName_All_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isCourseNameIsValid("123456"))
        }

        //section
        @Test
        fun sectionNumberValidator_CorrectSectionNumberSimple_ReturnsTrue() {
            assertTrue(StudentValidator.isSectionNumberIsValid("3"))
        }

        @Test
        fun sectionNumberValidator_InCorrectSectionNumberSimple_String_ReturnsTrue() {
            assertTrue(StudentValidator.isSectionNumberIsValid("section"))
        }

        @Test
        fun sectionNumberValidator_StartWith_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isSectionNumberIsValid("123section"))
        }

        @Test
        fun sectionNumberValidator_EndsWith_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isSectionNumberIsValid("Section123"))
        }

        @Test
        fun sectionNumberValidator_InvalidSectionNumber_GreaterThan_Two_Digit_ReturnsFalse() {
            assertFalse(StudentValidator.isSectionNumberIsValid("123456"))
        }
        //Department

        @Test
        fun departmentNameValidator_CorrectDepartmentNameSimple_ReturnsTrue() {
            assertTrue(StudentValidator.isDepartmentIsValid("Software"))
        }

        @Test
        fun departmentNameValidator_StartWith_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isDepartmentIsValid("123software"))
        }

        @Test
        fun departmentNameValidator_EndsWith_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isDepartmentIsValid("Software123"))
        }

        @Test
        fun departmentValidator_InvalidDepartmentName_All_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isDepartmentIsValid("123456"))

        }
        //Password

        @Test
        fun passwordValidator_InvalidPassword_All_Number_ReturnsFalse() {
            assertFalse(StudentValidator.isPasswordValid("123456"))
        }
        @Test
        fun passwordValidator_InvalidPassword_All_Character_At_Least_one__Number_ReturnsFalse() {
            assertFalse(StudentValidator.isPasswordValid("Password"))

        }

        @Test
        fun passwordValidator_InvalidPassword_LessThan_Six_Digit_ReturnsFalse() {
            assertFalse(StudentValidator.isPasswordValid("jo123"))
        }
        @Test
        fun passwordValidator_CorrectPasswordSample_ReturnsTrue() {
            assertTrue(StudentValidator.isPasswordValid("Password1234"))
        }

    }
}