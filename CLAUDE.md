# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Java library for the [Telegram Bot API](https://core.telegram.org/bots/api), published to Maven Central as `com.github.pengrad:java-telegram-bot-api`. It provides type-safe wrappers for all Telegram Bot API methods and models.

## Build and Test Commands

```bash
# Build
./gradlew build

# Run all tests (requires env vars - see Testing section)
./gradlew clean check

# Run PR tests (excludes long-running integration tests)
./gradlew clean check -PprTest

# Run a specific test class
./gradlew test --tests com.pengrad.telegrambot.TelegramBotTest

# Run a specific test method
./gradlew test --tests com.pengrad.telegrambot.TelegramBotTest.methodName

# Code coverage report
./gradlew jacocoTestReport
```

## Testing

Integration tests require a real Telegram bot. Set these environment variables:
- `TEST_TOKEN` — bot token
- `CHAT_ID` — test chat ID
- `GROUP_ID` — test group ID
- `PRIVATE_KEY` — for Passport decryption tests

Additional optional env vars: `TEST_PASSPORT_DATA`, `TEST_CALLBACK_QUERY`, `TEST_INLINE_QUERY`, etc.

## Architecture

This is a multi-module Gradle project:
- `library/` — the published library
- `sample/` — usage examples

### Core Data Flow

1. Instantiate a request object: `new SendMessage(chatId, "text")`
2. Execute synchronously: `bot.execute(request)` → returns typed response
3. Or execute asynchronously: `bot.execute(request, callback)`

Internally, `TelegramBotClient` serializes the request to an HTTP POST using Gson, calls `api.telegram.org/bot<token>/<MethodName>`, and deserializes the JSON response into a typed response class.

### Key Classes

- **`TelegramBot`** (`library/.../TelegramBot.java`) — Main entry point. Built via `new TelegramBot(token)` or `new TelegramBot.Builder(token).build()` for custom OkHttp/Gson config.
- **`TelegramBotClient`** (`library/.../impl/TelegramBotClient.java`) — OkHttp3 HTTP client; handles all serialization and deserialization.
- **`BaseRequest<T extends BaseRequest, R extends BaseResponse>`** (`library/.../request/BaseRequest.java`) — Generic base for all request classes. Uses generics to link each request type to its response type.
- **`BaseResponse`** (`library/.../response/BaseResponse.java`) — Base for all response classes. Contains `ok`, `errorCode`, `description`.

### Package Structure

- `request.*` — ~100+ request classes, one per Telegram API method (e.g., `SendMessage`, `GetUpdates`, `AnswerCallbackQuery`)
- `model.*` — ~100+ model classes for Telegram types (e.g., `Message`, `User`, `Chat`, `Update`)
- `response.*` — Typed response wrappers (e.g., `SendResponse`, `GetUpdatesResponse`)
- `passport.*` — Telegram Passport decryption logic
- `impl.*` — Internal HTTP client and update handler implementations

### Update Processing

Two modes are supported:
- **Polling**: Call `bot.setUpdatesListener(updates -> { ... })` to start background polling via `getUpdates`.
- **Webhook**: Parse incoming webhook payloads with `bot.parseUpdate(json)`.

The `UpdatesHandler` / `SleepUpdatesHandler` classes manage the polling loop internally.

## Conventions

- Every Telegram API method maps 1:1 to a class in `request.*` and a class in `response.*`.
- Request classes use a fluent builder pattern: `new SendMessage(chatId, text).parseMode(ParseMode.HTML).replyMarkup(keyboard)`.
- All model and request classes follow Telegram API naming closely (snake_case field names deserialized by Gson into camelCase Java fields).
- The library targets Java 8 runtime compatibility, though JDK 11+ is required to build.
