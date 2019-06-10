package com.example.Attendance

class EmailValidator {

        companion object {
            @JvmStatic val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(/.)(.{1,})";
            fun isValidEmail(email: String): Boolean {
                return EMAIL_REGEX.toRegex().matches(email)
            }
        }
    }

    fun main() {
        println(EmailValidator.isValidEmail("name@email.com"))
        println(EmailValidator.isValidEmail("name@email.co.uk"))
        println(EmailValidator.isValidEmail("name@email"))
        println(EmailValidator.isValidEmail("name@email..com"))
        println(EmailValidator.isValidEmail("@email.com"))
        println(EmailValidator.isValidEmail(""))
        println(EmailValidator.isValidEmail("name@007.com"))
        println(EmailValidator.isValidEmail("_Email007.com"))
        println(EmailValidator.isValidEmail("_Email007@abc.co.in"))
        println(EmailValidator.isValidEmail("Email.007@abc.com"))

    }


