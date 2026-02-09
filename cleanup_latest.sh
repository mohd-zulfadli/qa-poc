#!/bin/zsh

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

# Cypress artifacts
echo "🧹 Removing Cypress screenshots, videos, results, and node_modules..."
rm -rf cypress-tests/cypress/screenshots
rm -rf cypress-tests/cypress/videos
rm -rf cypress-tests/cypress/results
rm -rf cypress-tests/node_modules

# Clear Cypress cache directly (skip npx prompt)
echo "🧹 Clearing Cypress cache..."
rm -rf ~/Library/Caches/Cypress

# Clear npm cache
echo "🧹 Clearing npm cache..."
npm cache clean --force

# Clear general macOS caches (safe only, skip protected ones)
echo "🧹 Clearing system caches..."
rm -rf ~/Library/Caches/* 2>/dev/null
rm -rf ~/Library/Logs/*
rm -rf ~/Library/Developer/Xcode/DerivedData/*

# Reinstall Cypress dependencies
echo "📦 Reinstalling Cypress dependencies..."
cd cypress-tests && npm install && cd ..

# Reinstall Playwright dependencies (if package.json exists at root)
if [ -f "package.json" ]; then
  echo "📦 Reinstalling Playwright dependencies..."
  npm install
  # Install only Chromium to save space (optional)
  npx playwright install chromium
fi

echo "✅ Cleanup and reinstall complete. Ready for a fresh run!"

