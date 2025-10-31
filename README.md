**LINE ENCODING** is a technique to convert digital bits into a specific pattern of signal for transmission over a medium . 
It defines how 0s and 1s aer represented using voltage levels . It is a language that bits speak while they travel across a medium or cable . 
It is used to correct : - DC component , Baseline Wandering , Synchronization issues . 
- NRZ-L
- NRZ-I
- Manchester Encoding
- Differential Manchester Encoding
- AMI


1. **NRZ-L (Non-Return to Zero – Level)**
Logic:
Bit 1 → High Voltage
Bit 0 → Low Voltage

2. **NRZ-I (Non-Return to Zero – Inverted)**
Logic:
Bit 1 → Transition (invert the level)
Bit 0 → No Change

3. **Manchester Encoding**
Logic:
Bit 1 → High → Low
Bit 0 → Low → High
It is a mixture of RZ(return to zero) and NRZ-L(non-return to zero- level). Because of which it has a mid-bit transition.

4. **Differential Manchester Encoding**
Logic:
Always a mid-bit transition
Bit 0 → Transition at start
Bit 1 → No transition at start

5. **AMI (Alternate Mark Inversion)**
Logic:
Bit 0 → No pulse (0V)
Bit 1 → Alternates between +V and -V

### SCRAMBING TECHNIQUE 
used with AMI , for long data streams . 
Used to prevent loss of synchronization.
- *B8ZS*
Logic:
When 8 consecutive 0s occur, they are replaced with a special pattern that includes two bipolar violations.
000VB0VB

- *HDB3*
Logic:
Replaces every four 0s with 000V or B00V, depending on polarity and number of preceding nonzero pulses.
odd - 000V
even - B00V
V - violation 
B - balancing pulse 


| **Function / Class**    | **Purpose / Description**                                                                              |
| ----------------------- | ------------------------------------------------------------------------------------------------------ |
| `StringBuilder`         | Used to efficiently build or modify strings without creating multiple new string objects.              |
| `.append()`             | Adds more characters or text to the existing string inside a `StringBuilder`.                          |
| `.reverse()`            | Reverses the entire content of a string (used in palindrome checking).                                 |
| `.toString()`           | Converts the `StringBuilder` back into a normal `String` value.                                        |
| `.trim()`               | Removes leading and trailing spaces from user input to clean the data.                                 |
| `.add()`                | Adds new data elements (bits or voltages) into the ArrayList during encoding.                          |
| `switch-case`           | Controls which encoding or decoding logic to use based on user’s selection (NRZ-L, AMI, etc.).         |
| `for-each` / `for` loop | Iterates through bits or signals while encoding and decoding.                                          |
| `if-else`               | Implements the logical conditions used in encoding rules (e.g., polarity flip, zero detection).        |
| `String`                | Represents the bitstream entered by the user (sequence of 0s and 1s).                                  |
| `.charAt()`             | Reads each bit (character) from the input string one by one.                                           |
| `.equals()`             | Compares two strings (used in palindrome validation and equality checks).                              |
