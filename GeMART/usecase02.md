# ユースケース2：ログインする

## 概要
ユーザがシステムにログインして，ユーザ個人に適用されたメニューの閲覧，料理から除外したい食材の登録が行えるようになる。

## アクター
- ユーザ

## 事前条件
- システムにログインしていないこと

## 事後条件
- ユーザがシステムにログインした状態になる
- システムにメニューの一覧が表示された状態になる

## トリガー
- ユーザがシステムの使用を開始する

## 基本フロー
1. システムは，ログイン画面を表示する。
2. ユーザは，ユーザIDとパスワードを入力し，ログインボタンを押す。
3. システムは，ユーザIDでユーザ情報を検索し，パスワードが一致するかをチェックする。
4. パスワードが一致すれば，システムはユーザをログイン状態にする。
5. システムはメニューの一覧を画面に表示する。

## 代替フロー
### 代替フロー1
- 3a.1 基本フロー3でユーザIDEが存在しない場合，システムはログインエラーを出し，1に戻る。

### 代替フロー2
- 4a.1 基本フロー4でパスワードが一致しない場合，システムはログインエラーを出して，1に戻る。

## GUI紙芝居
### ログイン画面