#!/bin/zsh

echo "🔄 Cleaning QA-POC project..."

# Maven artifacts (JUnit, TestNG, Karate)
echo "🧹 Cleaning Maven target directories..."
mvn clean


# Robot outputs
echo "🧹 Removing Robot Framework outputs..."
rm -rf robot-output/

# Playwright artifacts
echo "🧹 Removing Playwright reports..."
rm -rf playwright-report/

# Clear Cypress binary cache (macOS)
echo "�� Clearing Cypress cache..."
npx cypress cache clear

# Cypress artifacts
echo "🧹 Removing Cypress screenshots, videos, results, and node_modules..."
rm -rf cypress-tests/cypress/screenshots
rm -rf cypress-tests/cypress/videos
rm -rf cypress-tests/cypress/results
rm -rf cypress-tests/node_modules
rm -rf ~/Library/Caches/Cypress
npm cache clean --force

# Reinstall Cypress dependencies 
echo "📦 Reinstalling Cypress dependencies..." 
cd cypress-tests && npm install && cd .. 

# Reinstall Playwright dependencies (if package.json exists at root or in a playwright-tests folder) 
if [ -f "package.json" ]; then 
	echo "📦 Reinstalling Playwright dependencies..." 
	npm install 
fi 

echo "✅ Cleanup and reinstall complete. Ready for a fresh run!"

