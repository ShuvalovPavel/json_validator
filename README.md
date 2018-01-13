Application for validation of JSON files.

Returns the contents of the file if the validation is successful
Returns an error if validation is not successful

Use:
Run server "sudo docker build -t json_validator https://github.com/ShuvalovPavel/json_validator.git && docker run --rm -d -p 8080:8080 json_validator". 
To send the file, use the command "curl -s --data-binary @f.json localhost:8080"
