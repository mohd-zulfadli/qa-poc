describe('Example Page Test', () => {
  it('should have correct title', () => {
    cy.visit('https://example.com');
    cy.title().should('eq', 'Example Domain');
  });
});
