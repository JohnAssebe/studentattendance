package com.example.Attendance

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class LoginValidatorUnitTest{

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }
    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }
    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }
    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }
    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }
    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }
    @Test
    fun emailValidator_At_Annotation_InBetweenOf_EmailUsername() {
        assertFalse(EmailValidator.isValidEmail("name@007.com"))
    }
    @Test
    fun emailValidator_WithOut_At_Annotation() {
        assertFalse(EmailValidator.isValidEmail("name007.com"))
    }
    @Test
    fun emailValidator_With_At_Annotation_Preceeding_Numbers_WithSubDomains() {
        assertFalse(EmailValidator.isValidEmail("name007@abc.co.uk.com"))
    }
    @Test
    fun emailValidator_With_Dot_Before_At_Annotation() {
        assertFalse(EmailValidator.isValidEmail("name.007@abc.com"))
    }

}
