package assertions;

import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.response.Response;
import logger.Log4JLogger;
import org.apache.http.HttpStatus;
import org.openqa.selenium.By;
import org.testng.asserts.Assertion;

public class Assert {
    public Assert() {
    }

    public Assert textToBe(@NotNull final String actualText, @NotNull final String expectedText) {
        try {
            new Assertion().assertEquals(actualText, expectedText);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual text {" + actualText + "} is equals to the expected text {" + expectedText + "}");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert attributeToBe(@NotNull final String attribute, @NotNull final boolean expected) {
        try {
            new Assertion().assertEquals(attribute, expected);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert attributeToBe(@NotNull final String attribute, @NotNull final String expected) {
        try {
            new Assertion().assertEquals(attribute, expected);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert objectEquals(@NotNull final Object actual, @NotNull final Object expected) {
        try {
            new Assertion().assertEquals(actual, expected);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual {" + actual + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert objectNotEquals(@NotNull final Object actual, @NotNull final Object expected) {
        try {
            new Assertion().assertNotEquals(actual, expected);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual {" + actual + "} not equals to the expected {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert assertTrue(@NotNull final boolean condition) {
        try {
            new Assertion().assertTrue(condition);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual condition is: {" + condition + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert assertFalse(@NotNull final boolean condition) {
        try {
            new Assertion().assertFalse(condition);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual condition is: {" + condition + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert assertNotNull(@NotNull final Object expected) {
        try {
            new Assertion().assertNotNull(expected);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual condition is: {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }
    public Assert assertNull(@NotNull final Object expected) {
        try {
            new Assertion().assertNull(expected);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual condition is: {" + null + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert responseStatusCodeEquals(@NotNull final Response response, @NotNull final StatusCode statusCode) {
        try {
            switch (statusCode) {
                case SC_OK -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {200 SC_OK}");
                }
                case SC_CREATED -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {201 SC_CREATED}");
                }
                case SC_ACCEPTED -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_ACCEPTED);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {202 SC_ACCEPTED}");
                }
                case SC_BAD_REQUEST -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {400 SC_CREATED}");
                }
                case SC_UNAUTHORIZED -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_UNAUTHORIZED);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {401 SC_UNAUTHORIZED}");
                }
                case SC_FORBIDDEN -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_FORBIDDEN);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {403 SC_FORBIDDEN}");
                }
                case SC_NOT_FOUND -> {
                    new Assertion().assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
                    Log4JLogger.logINFO(Assert.class, new Object() {
                            }.getClass().getEnclosingMethod().getName(),
                            "Actual Status Code {" + response.getStatusCode() + "} is equals to the expected {404 SC_NOT_FOUND}");
                }
            }
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert responseAttributeEquals(@NotNull final Response response, @NotNull final String jsonPath, @NotNull final Object expected) {
        try {
            new Assertion().assertEquals(response.jsonPath().get(jsonPath), expected);
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Actual response attribute value{" + jsonPath + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert responseAttributeNotNull(@NotNull final Response response, @NotNull final String jsonPath) {
        try {
            new Assertion().assertNotNull(response.jsonPath().get(jsonPath));
            Log4JLogger.logINFO(Assert.class, new Object() {
                    }.getClass().getEnclosingMethod().getName(),
                    "Expected response attribute: {" + jsonPath + "}" + " exists");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }
}