setup:
	python3 -m venv ~/.capstone
	source ~/.capstone/bin/activate

env:
	which python3
	python3 --version
	which pylint

install:
	pip install --upgrade pip &&\
		pip install -r requirements.txt

lint:
	hadolint Dockerfile
	pylint --disable=R,C,W1203,W1202 app.py

