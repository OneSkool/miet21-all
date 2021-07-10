# Instruction to setup locally

1. Before running for the first time, get dependencies

```
npm i
```

2. To run locally

```
npm run dev
```

3. To run on Google Cloud

- Download and install 'gcloud' command line tools. Use this link: [Google SDK](https://cloud.google.com/sdk/docs/quickstart).

Follow directions to initialize SDK. You will have to enable Billing (use free credits) and CloudRun and few other services along the way.

Alternatively, you can use Cloud Build but having local setup helps.

4. Once Google Cloud is configured, run following commands to deploy this service under a project on Google Cloud.

a. Create a 'project' (use UI). You can also do it from command line by supplying a unique id

```
gcloud projects create onekskool-training-id --name oneskool-training
```

# Build and Deploy on Google Cloud

1. Run command to build container on google cloud from project root

```
gcloud builds submit --tag gcr.io/oneskool-training/js-api:latest --project=oneskool-training
```

Follow prompts to enable cloud build etc.

Verify / View builds

```
gcloud builds list --project=oneskool-training
```

2. Deploy application

```
gcloud beta run deploy webapp --image gcr.io/oneskool-training/js-api:latest --port=8080 --platform managed --region us-east4 --project=oneskool-training
```

Follow prompts to enable run.googleapis.com etc.

# Clean up every now and then to keep cost low

1. Clean up container images for unsuccessful or old builds. Keep last 1-2 copied to allow for redeployment.

```
gcloud container images list --project=oneskool-training
```

Delete example. Replace the image with the one you want to delete

```
gcloud container images delete gcr.io/oneskool-training/js-api:latest --project=oneskool-training
```

# Build and run docker container locally
Run following commands from project root

```
docker build -f Dockerfile -t js-api:latest .
```

Run container

```
docker run --name api-c1 -it -p 3000:3000 js-api:latest
```
