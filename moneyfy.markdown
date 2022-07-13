***Monefy exploratory testing***

**Basic functions (+, -):**

*Adding incomes*

|  No | Given   | When   |  Then | 
|---|---|---|---|
| 1 |  Add 1000 usd, category: salary |  check balance | Balance should be 1000  |  
| 2 | Add 100 eur, category: savings | check balance | Balance = 1100 |

*Adding expences*

|  No | Given   | When   |  Then | 
|---|---|---|---|
| 1 | spent 500 usd, category: house | check balance | spent = 500 |
| 2 | spent 50, cat: eating out | check balance | spent = 550, diagram shows 9% and 91% |



**Search module**

|  No | Given   | When   |  Then | 
|---|---|---|---|
| 1 | open search, type: eat | check search results | "eating out $ 50" appears |




**Transer module**

|  No | Given   | When   |  Then | 
|---|---|---|---|
| 1 | Open "Transfer" window, Transfer to $100 to Payment card | check Accounts | Balance still = 550, In Accounts section: cash: $450, card: $100 |



**Filter module**

|  No | Given   | When   |  Then | 
|---|---|---|---|
| 1 | Add $100 expence, category: car, date: yesterday | check diagram |  Balance: $450, new category used in chart |



**Balance module**

|  No | Given   | When   |  Then | 
|---|---|---|---|
| 1 | Open balance section | Switch to date data view | Balance moves by date appears |


**Diagram section**

|  No | Given   | When   |  Then | 
|---|---|---|---|
| 1 | Tap on "Phone" icon, add $10 expence | Click add | Diagram correctly appears, no needs to choose category |
