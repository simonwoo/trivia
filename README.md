# Trivia
Trivia原本是一个答题闯关的游戏，比赛参赛者先投色子来抽取要回答的问题，如果回答正确会获得金币，回答错误则要受罚。当出现参赛者获得指定数目枚金币后，则获胜，游戏结束。该项目中包含了大量烂代码。我们所要做的就是驯服这些烂代码，达到重构的目的。

## 步骤
1. 运行GameRunner中的main方法，观察程序运行过程以及如何调用Game类的公共方法的。
2. 观察Game类中这些公共方法的实现，清楚每个方法的行为。
3. 为这些行为写特征测试，保证这些行为不会改变。
4. 开始重构。
	- 将Game类拆分为几个新类。从Game的行为中，我们可以抽取出Player和Question类。将与他们相关的属性放入其中，如Player中应包含玩家的金牌数目，姓名等。
	- 消除重复代码。

## 细节
对于Game游戏，共分为四类问题，每类问题中有50道。每类问题的结构一样，我使用Java类的枚举结构，将四类问题放在一起，共同构成了Game的问题集合。

```java
public enum Question {
        POP("POP"), SCIENCE("Science"), SPORTS("Sports"), ROCK("Rock");

        private String category;

        private List<String> questions;

        private Question(String category) {
            this.category = category;
            this.questions = new ArrayList<String>();

            for (int i = 0; i < 50; i++) {
                questions.add(category + " Question " + i);
            }
        }
    }

```

trivia项目原本代码放在master分支，重构后的代码放在refactoring分支。

关于代码重构的原则请参考: [refactoring](https://sourcemaking.com/refactoring)。