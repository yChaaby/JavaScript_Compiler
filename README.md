# JavaScript Compiler Project


## Introduction

Welcome to the **JavaScript Compiler Project**. The goal of this project is to develop a compiler capable of translating specific fragments of JavaScript code into a custom assembly language. This endeavor involves two critical stages:

1. **Parsing**: Ensuring the input JavaScript code adheres to the expected syntax.
2. **Compilation**: Transforming valid JavaScript code into executable assembly code compatible with a provided virtual machine.

This project allows us to explore the inner workings of parsers, lexers, and compilers while adhering to strict project specifications.

### What is a Parser and Lexer?

- **Lexer (Lexical Analyzer)**: The lexer processes raw input text and breaks it into manageable units called tokens, such as identifiers, keywords, and operators. It serves as the first step in transforming code into a structured format.
- **Parser**: The parser takes these tokens and organizes them according to grammatical rules, constructing a syntax tree that represents the structure of the code.

### Parser Type Used

In this project, we implemented a **LL(k) parser** using JavaCC, which processes input from left to right and constructs a **leftmost derivation** of the input. LL parsers are well-suited for context-free grammars and allow us to easily handle JavaScript's hierarchical structure.



## Fragments Overview

The compiler supports multiple JavaScript fragments, incrementally expanding its capabilities. The development covers fragments 0 through 8, starting with arithmetic expressions and progressing to advanced constructs like exceptions and classes. Each fragment builds upon the previous one, integrating features such as:

- Boolean operations
- Variables
- Loops
- Functions
- Dynamic types
- Object-oriented programming

---

## Required Software

To run this project, you'll need:

- **Java** (version 8 or higher)
- **JavaCC** (for parser and lexer generation)
- A **Shell terminal** with appropriate packages installed

---

## How to Compile the Project

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
    ```
2. Compile the parser:
   ```bash
   #modify you test.js file
   ./mi-makefile.sh
   ```
3. The generated code can be excecuted in the virtual machine : <br/>
   http://lipn.univ-paris13.fr/~breuvart/compilation/interpreteurJS/
## Grammar
  ```markdown
<program> ::= ϵ | <command> <program>

<command> ::= <expression> ;
            | import <IDENT> ;
            | ;
            | {<program>}
            | let <IDENT> ;
            | if ( <expression> ) <command> else <command>
            | while ( <expression> ) <command>
            | function <IDENT> (<decl_args>) { <program> }
            | return <expression> ;
            | try { <program> } catch ( <IDENT> ) { <program> }

<decl_args> ::= ϵ | <IDENT> | <IDENT> , <decl_args>

<expression> ::= <NUMBER> | <BOOLEAN> | <IDENT>
               | undefined
               | (<expression>)
               | <IDENT> = <expression>
               | <expression> + <expression>
               | <expression> - <expression>
               | <expression> * <expression>
               | <expression> / <expression>
               | <expression> == <expression>
               | <expression> > <expression>
               | <expression> >= <expression>
               | <expression> && <expression>
               | ! <expression>
               | - <expression>
               | <IDENT> ( <arguments> )
               | function (<decl_args>) { <program> }
               | (<decl_args>) => <expression>
               | {<object_content>} | Null
               | <expression> . <IDENT>

<arguments> ::= ϵ | <expression> | <expression> , <arguments>

  ```
