Feature: books create/get all/get by id/delete features
  Scenario: client call to GET /books
    When the client calls /books
    Then the client receives status code of 200
    And  the client receives a list size 3 of books