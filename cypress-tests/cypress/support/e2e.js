// support/e2e.js
// You can add global hooks or custom commands here
// For more information, visit https://docs.cypress.io/guides/core-concepts/writing-and-organizing-tests#Support-Files

// Example: A global before hook
before(() => {
  // Code to run before all tests
  cy.log('Starting Cypress E2E Tests');
});

// Example: A global after hook
after(() => {
  // Code to run after all tests
  cy.log('Finished Cypress E2E Tests');
}); 