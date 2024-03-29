package com.wladislove.password_validator.validator;

import com.wladislove.password_validator.annotation.PasswordMatches;

import static com.wladislove.password_validator.reflection.util.ReflectionUtil.accessFieldAndGet;

class PasswordMatcherValidator {

    boolean validatePassMatching(final Class<?> cl, final Object o) {
        if (cl.isAnnotationPresent(PasswordMatches.class)) {
            PasswordMatches passwordMatches = cl.getAnnotation(PasswordMatches.class);
            String password = accessFieldAndGet(passwordMatches.password(), cl, o);
            String matchingPassword = accessFieldAndGet(passwordMatches.matchingPassword(), cl, o);
            return password.equals(matchingPassword);
        }
        return true;
    }
}
