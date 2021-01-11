# play-api-sample

## ローカル環境の作成
```
git clone https://github.com/koty/play-api-sample
cd play-api-sample
docker-compose up -d
sbt run
```

作ったAPIはroutesを参照してください。

## heroku deploy
`heroku buildpacks:set heroku/scala` を実行して、ビルドパックを追加する必要があります。

### 必要な環境変数
heroku標準の`DATABASE_URL` 環境変数は使えません。独自の文字列を定義する必要があります。

`DATABASE_CONNECTION_URL` という変数を定義してください。値は `jdbc:postgresql://<hostname>:5432/<dbname>?user=<user>&password=<password>` の形式です。Procfileで変数を参照しています。

`APPLICATION_SECRET` という変数を定義してください。値はuuidなどのランダム文字列を設定してください。同じくProcfileで変数を参照しています。
