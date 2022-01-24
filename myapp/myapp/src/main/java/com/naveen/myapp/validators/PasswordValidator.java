package com.naveen.myapp.validators;


import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
    public class PasswordValidator {

        private static final String PASSWORD_PATTERN =
                "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        private final Pattern pattern;

    public PasswordValidator() {
            pattern = Pattern.compile(PASSWORD_PATTERN);
        }


        public boolean validate(final String password) {

            Matcher matcher = pattern.matcher(password);
            return matcher.matches();

        }
    }

