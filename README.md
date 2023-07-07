# -Context-Free-Grammars-Left-Recursion-Elimination
For this task you will implement the context-free grammar (CFG) left-recursion elimination algorithm introduced in Lecture 3 of CSEN1003. Recall that a CFG is a quadruple (V, Σ, R, S) where V and Σ are disjoint alphabets (respectively, containing variables and terminals), R ⊆ V ×(V ∪Σ)∗ is a set of rules, and S ∈ V is the start variable.

Requirements: I should implement a class constructor CfgLeftRecElim,and two methods;toString,
and eliminateLeftRecursion.

1.CfgLeftRecElim, a class constructor, takes one parameter which is a string description of a CFG and constructs a CFG instance. A string encoding a CFG is of the form V #T #R.

2.toString returns a string representation of a CFG. This string representation is the same as the one used for the input to the constructor.

3. eliminateLeftRecursion eliminates left recursion in the constructed CFG where a newly-introduced variable.
