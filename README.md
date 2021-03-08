# KafkaProducer

### Endpoints

| Method | Endpoint                    | Description                       |
|:-------|:----------------------------|:----------------------------------|
|`POST`| `/api/kafka/produce`      | Send a message |


### Body param request
{
	"id":1,
	"message": "this is a message to be sent by kafka producer",
	"obs": "none"
}
