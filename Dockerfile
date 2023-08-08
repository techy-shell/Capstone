FROM python:3.7.3-stretch

WORKDIR /capstone

COPY . app.py /capstone/


RUN #hadolint ignore=DL3013 &&\
    pip install --upgrade pip &&\
    pip install --trusted-host pypi.python.org -r requirements.txt

EXPOSE 80

CMD ["python", "app.py"]


