FROM python:3.7.3-stretch

WORKDIR /devops

COPY . app.py /devops/


RUN #hadolint ignore=DL3013 &&\
#    pip install --no-cache-dir --upgrade setuptools wheel --use-pep517 pip &&\
#    pip install --no-cache-dir --trusted-host pypi.python.org numpy &&\
#    pip install --no-cache-dir --trusted-host pypi.python.org -r requirements.txt
    pip install --upgrade pip &&\
    pip install --trusted-host pypi.python.org -r requirements.txt

EXPOSE 80

CMD ["python", "app.py"]


