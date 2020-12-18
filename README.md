# cmdlib-fabric

[![](https://jitpack.io/v/uten2c/cmdlib-fabric.svg)](https://jitpack.io/#uten2c/cmdlib-fabric)

BrigadierのFabric-Kotlin用ラッパー

## プロジェクトに追加する

Groovy DSL
```groovy
repositories {
    ... 
    maven { url 'https://jitpack.io' }
}

dependencies {
    ... 
    implementation 'com.github.uten2c:cmdlib-fabric:Tag'
}
```

Kotlin DSL
```kotlin
repositories {
    ...
    maven("https://jitpack.io")
}

dependencies {
    modImplementation("com.github.uten2c:cmdlib-fabric:Tag")
}
```

## コマンドサンプル

コマンドを登録するための`registerCommand`はトップレベルに宣言されています。

```kotlin
//引数はコマンド名
registerCommand("test") {
    
    //引数はOPレベル
    requires(2)
    //または、関数を書く
    // requires { source/*: ServerCommandSource*/ -> 
    //     something...
    // }
    
    // 「/test echo」でチャット欄に「Hello」と表示される
    literal("echo") {
        executes {
            source.sendFeedback(LiteralText("Hello"), false)
        }
    }
    
    // 「/test diamond <個数>」でダイヤモンドを入手するコマンド
    literal("diamond") {
        integer("amount", 1, 64) {
            executes {
                val stack = Items.DIAMOND.defaultStack.apply {
                    count = getInteger("amount")
                }
                player.inventory.insertStack(stack)
            }
        }
    }
    
    // 「/test fire」で対象のエンティティを燃やす
    literal("fire") {
        entity("target") {
            executes {
                val target = getEntity("target")
                target.setOnFireFor(10)
            }
        }
    }
    
    // 「/test error」でエラー出力する
    literal("error") {
        executes {
            throw CommandException(LiteralText("これでエラーが出るよ"))
        }
    }
}
```

### 複数の補完を表示する場合

リストなどの複数のサンプルを表示したい場合は繰り返し処理で書くといい感じです。

```kotlin
registerCommand("hello") {
    val list = listOf(GameMode.CREATIVE, GameMode.SPECTATOR, GameMode.SURVIVAL, GameMode.ADVENTURE)
    list.forEach { mode ->
        literal(mode.getName()) {
            executes {
                player.setGameMode(mode)
            }
        }
    }
}
```

## ヒント
### 引数
引数は色々ありますが基本的に設定する場合は「引数名」取得する場合は「get引数名」となっています。

例: 「player」と「getPlayer」、「itemStack」と「getItemStack」など

バニラに実装されている引数の種類はほとんど実装してるはずなので補完で色々探してみてください。

### 実行したプレイヤーを取得
`executes`内の`player`変数で実行したプレイヤーを取得できます。

`player`を使用した場合、プレイヤー以外が実行すると自動でエラーができようになっています。

つまり、if文などでチェックをしなくていいってことです。
