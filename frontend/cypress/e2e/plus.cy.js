describe('덧셈 기능 테스트', () => {
    beforeEach(() => {
        cy.visit('/');
    });

    it('두 숫자를 더하면 합계를 반환한다', () => {
        cy.get('[data-testid="input-num1"]').type('5');
        cy.get('[data-testid="input-num2"]').type('3');
        cy.get('[data-testid="add-button"]').click();
        cy.get('[data-testid="result"]').should('contain', 'Sum: 8');
    });

    it('유효하지 않은 요청 시 에러 메시지를 표시한다.', () => {
        cy.get('[data-testid="input-num1"]').type('5');
        cy.get('[data-testid="add-button"]').click();
        cy.get('[data-testid="error-message"]').should('contain', 'num2 must not be null');
    });

    it('음수를 입력하면 올바른 결과를 반환한다', () => {
        cy.get('[data-testid="input-num1"]').type('-5');
        cy.get('[data-testid="input-num2"]').type('-3');
        cy.get('[data-testid="add-button"]').click();
        cy.get('[data-testid="result"]').should('contain', 'Sum: -8');
    });

    // 추가 테스트 케이스들...
});