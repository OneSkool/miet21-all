# Inherit from the Python Docker image 
FROM python:3.7-slim 

# Install the web framework “Flask” via the package manager, pip 
RUN pip install scrapy 

# Copy the source code to app folder 
COPY ./src/ /app/ 

# Change the working directory 
WORKDIR /app/ 

RUN useradd -ms /bin/bash appuser
USER appuser 

# Set "python" as the entry point 
ENTRYPOINT ["/bin/bash","-c"] 

# Set the command as the script name 
CMD ["python app.py"]
