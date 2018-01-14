Application for validation of JSON files.

Returns the contents of the file if the validation is successful
Returns an error if validation is not successful

Use:
Run server 
```bash
sudo docker build -t json_validator https://github.com/ShuvalovPavel/json_validator.git && docker run --rm -d -p 80:80 json_validator 
```
To send the file, use the command 
```bash
curl -s --data-binary @f.json localhost:80
```
