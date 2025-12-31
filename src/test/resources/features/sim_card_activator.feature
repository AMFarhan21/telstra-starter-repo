Feature: SIM Card Activation

    Scenario: Successful SIM card activation
        Given a functional sim card
        When a request to activate the sim card is submitted
        Then the sim card is activated and its state is recorded to the database

    Scenario: Successful SIM card activation
        Given a broken sim card
        When a request to activate the sim card is submitted
        Then the sim card fails to activate and its state is recorded to the database