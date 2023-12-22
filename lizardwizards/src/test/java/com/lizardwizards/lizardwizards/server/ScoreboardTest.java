package com.lizardwizards.lizardwizards.server;


import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;


/**
 * Parasoft Jtest UTA: Test class for Scoreboard
 *
 * @see Scoreboard
 * @author povilas
 */
public class ScoreboardTest
{
    /**
     * Parasoft Jtest UTA: Test for addBossHealth(double)
     *
     * @author povilas
     * @see Scoreboard#addBossHealth(double)
     */
    @Test
    public void testAddBossHealth() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Scoreboard underTest = Scoreboard.getInstance();

            // When
            double bossHealth = 0.0d; // UTA: default value
            underTest.addBossHealth(bossHealth);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for addScore(int)
     *
     * @author povilas
     * @see Scoreboard#addScore(int)
     */
    @Test
    public void testAddScore() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Scoreboard underTest = Scoreboard.getInstance();

            // When
            int score = 0; // UTA: default value
            underTest.addScore(score);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getBossHealth()
     *
     * @author povilas
     * @see Scoreboard#getBossHealth()
     */
    @Test
    public void testGetBossHealth() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Scoreboard underTest = Scoreboard.getInstance();

            // When
            double result = underTest.getBossHealth();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getInstance()
     *
     * @author povilas
     * @see Scoreboard#getInstance()
     */
    @Test
    public void testGetInstance() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // When
            Scoreboard result = Scoreboard.getInstance();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for getScore()
     *
     * @author povilas
     * @see Scoreboard#getScore()
     */
    @Test
    public void testGetScore() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Scoreboard underTest = Scoreboard.getInstance();

            // When
            int result = underTest.getScore();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for initBossHealth(double)
     *
     * @author povilas
     * @see Scoreboard#initBossHealth(double)
     */
    @Test
    public void testInitBossHealth() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Scoreboard underTest = Scoreboard.getInstance();

            // When
            double bossHealth = 0.0d; // UTA: default value
            underTest.initBossHealth(bossHealth);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for resetBossHealth()
     *
     * @author povilas
     * @see Scoreboard#resetBossHealth()
     */
    @Test
    public void testResetBossHealth() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Scoreboard underTest = Scoreboard.getInstance();

            // When
            underTest.resetBossHealth();

        });
    }

    /**
     * Parasoft Jtest UTA: Test for subtractBossHealth(double)
     *
     * @author povilas
     * @see Scoreboard#subtractBossHealth(double)
     */
    @Test
    public void testSubtractBossHealth() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Scoreboard underTest = Scoreboard.getInstance();

            // When
            double bossHealth = 0.0d; // UTA: default value
            underTest.subtractBossHealth(bossHealth);

        });
    }

    /**
     * Parasoft Jtest UTA: Test for subtractScore(int)
     *
     * @author povilas
     * @see Scoreboard#subtractScore(int)
     */
    @Test
    public void testSubtractScore() throws Throwable {
        // UTA is unable to resolve the values required to create the requested test case.
        // A test case with default values has been created instead.

        assertTimeoutPreemptively(ofMillis(5000), () -> {
            // Given
            Scoreboard underTest = Scoreboard.getInstance();

            // When
            int score = 0; // UTA: default value
            underTest.subtractScore(score);

        });
    }
}