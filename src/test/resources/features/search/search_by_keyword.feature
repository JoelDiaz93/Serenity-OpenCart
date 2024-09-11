Feature: Search by keyword

  @MacBook
  Scenario: Searching for 'MacBook'
    Given Sergey is researching things on the internet
    When he looks up "MacBook"
    When he select article "MacBook"
    When he click to "Add to Cart"
    When he should see alert success buy to "MacBook"
    When he looks up "iPhone"
    When he select article "iPhone"
    When he click to "Add to Cart"
    When he click to view cart and CheckOut
    When he select a "Guest Checkout"
    When he click to Continue
    When he enters his personal "Carlos", "Diaz", "email@gmail.com", "0999999999"
    When he enters his address "Company", "Direccion cualquiera", "Quito", "170123", "Ecuador", "Pichincha"
    When he click to Continue
    When he payment method
    When he click to Continue
    When he click to Continue
    Then he should see alert success order

