# VT Spring Boot 学習用

## 環境構築

## Git リポジトリの作成

1. 自身のgithubページから新規リポジトリを作成する
2. リポジトリ名を入力後、そのまま「Create Repository」ボタンを押下し登録する
    * リポジトリ名: `spring-boot-api-training`

### 作業場所

作業場所へ移動する

```sh
cd 任意の作業場所
```

### Git設定

```sh
# プロジェクトに移動
cd spring-boot-api-training

# git履歴削除
rm -rf .git
# git初期化
git init
# コミット対象とするためステージングへ追加
git add .
# gitの差分チェック（差分データが正しいか確認する）
git status
# コミット作成
git commit -m 'first commit'
# mainブランチを作成
git branch -M main
# mainブランチが作成されているか確認
git branch
# リモートと紐づけ
git remote add origin https://github.com/自分gituhubのアカウント/spring-boot-api-training.git
# リモートへプッシュ
git push -u origin main
```

### JDKの設定

※コマンド: `java -version`を実行し、適切なバージョンが表示されればJDKの設定はスキップしてよい

1. JDK インストール
    * 対象バージョン: 17
    * Oracle: https://www.oracle.com/java/technologies/downloads/?er=221886
        * Intel Macと、M1やM2は異なるインストーラーを使用するため適切なものをダウンロードしインストールする
2. インストール済みのJDKのパスの確認
    * コマンド: `/usr/libexec/java_home -V`
        * インストール済みのものがある場合、以下のようなjdkの一覧が表示される
        * jdkにも色々種類があるが、今回はOracleのJDKを使用する
            * 補足: Eclipse（Pleiades All in One）をダウンロード済みの場合は基本的にはJDKをダウンロードする必要はない

【実行結果】

```log
/usr/libexec/java_home -V
Matching Java Virtual Machines (10):
    21.0.5 (arm64) "Oracle Corporation" - "Java SE 21.0.5" /Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home
    17.0.3 (x86_64) "Eclipse Adoptium" - "OpenJDK 17.0.3" /Library/Java/JavaVirtualMachines/jdk-17.0.3+7/Contents/Home
    16.0.1 (x86_64) "AdoptOpenJDK" - "AdoptOpenJDK 16" /Library/Java/JavaVirtualMachines/adoptopenjdk-16.jdk/Contents/Home
    15.0.1 (x86_64) "AdoptOpenJDK" - "AdoptOpenJDK 15" /Library/Java/JavaVirtualMachines/adoptopenjdk-15.jdk/Contents/Home
    11.0.16 (x86_64) "Amazon.com Inc." - "Amazon Corretto 11" /Users/ユーザー名/Library/Java/JavaVirtualMachines/corretto-*********/Contents/Home
    11.0.15 (x86_64) "Eclipse Adoptium" - "OpenJDK 11.0.15" /Library/Java/JavaVirtualMachines/jdk-11.0.15+10/Contents/Home
    11.0.15 (x86_64) "Eclipse Adoptium" - "OpenJDK 11.0.15" /Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home
    11.0.10 (x86_64) "AdoptOpenJDK" - "AdoptOpenJDK 11" /Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home
    1.8.333.02 (x86_64) "Oracle Corporation" - "Java" /Library/Internet Plug-Ins/JavaAppletPlugin.plugin/Contents/Home
    1.8.0_265 (x86_64) "AdoptOpenJDK" - "AdoptOpenJDK 8" /Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home
/Library/Java/JavaVirtualMachines/jdk-21.jdk/Contents/Home
```

3. jdkのパスの設定
    * コマンド: `ls ~/.zshrc` で `.zshrc` ファイルの確認
        * 存在しない場合 `touch ~/.zshrc` で新規作成
    * コマンド: `view ~/.zshrc` で中身を確認
    * キー: `i` を押下して、INSERTモードへ変更する
        * 十字キーで移動し、以下の【.zshrc】の内容を入力（貼り付けでもOK）
        * 他の設定が書かれている場合は、他の設定を書き換えないように注意する
    * キー: `esc` を押下し、`:wq!` と入力して `Enter` を押下し保存する
        * 注意: `:wq!` はコピペではなく手入力で行うこと

【.zshrc】
以下2行を追加する

```zsh: .zshrc
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$JAVA_HOME/bin:$PATH
```

4. 設定の適用
    * コマンド: `source ~/.zshrc`
       * 設定ファイルを保存しただけでは適用されないため、上記コマンドを実行する
5. Java バージョン確認
    * コマンド: `java -version`
       * javaバージョンが表示されればOK


## VSCodeの設定

### Extension

VSCodeの拡張機能から以下を検索してインストールする

* 必須
    * Extension Pack for Java
    * Spring Boot Extension Pack
    * Gradle for Java
* 任意
    * Japanese Language Pack for Visual Studio Code
    * Trailing Spaces
    * Better Comments

## 実行

Javaの起動を待ち、実行する

【Java Ready】

以下のようにJavaの読み込みが完了したら実行する

<img src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/3725756/296e897c-7946-a29d-32bc-7f67c1fd3563.png" width="800">


【実行】

1. Spring Boot Dashboardを選択する
2. APPS配下にある api-demo の右側「▷」ボタンを押下する

<img src="https://qiita-image-store.s3.ap-northeast-1.amazonaws.com/0/3725756/93007f1d-ddf5-abe5-7423-7b2c803bfe40.png" width="800">

## Tips

### Z Shell（Zシェル）とは

* システム内の設定処理を行うことができるインターフェース
    * 今回はJavaを利用するためのJDKのパス設定を行うために利用
* macOS Catalina（10.15）以降のデフォルトシェル、それまではBashと呼ばれる下位互換のシェルが普及していた
* MacがM1やM2の場合、「.bashrc」ではなく、「.zshrc」こちらがデフォルト
