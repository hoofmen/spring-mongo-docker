## Google Kubernetes Deployment
    (!) All the next commands are meant to be run from local machine
### Prerequisites
* Google Kubernetes cluster (created)
* gcloud command line tool
* kubeclt command line tool
* docker

After install gcloud make sure you are loged in using `gcloud auth login`, the login account should have access to the google cloud project!
### 1. Push DockerImage to your google registry
* Configure local docker with google cloud 
`gcloud auth configure-docker`
* Build docker Image locally
* Tag the docker image (if you want a version) 
`docker tag IMAGE_NAME IMAGE_NAME:VERSION`
* Push the tagged docker image to google cloud registry 
`docker push gcr.io/GOOGLE_PROJECT_ID/IMAGE_NAME:VERSION`

### 2. Create a persistent disk for the database

	gcloud compute disks create --size=1GB --zone=us-central1-a mongo-disk

### 3. Run the deployment.yml file
    (!) Make sure you are pointing the right project ID at line 35 

* Configure kubeclt with google cloud
`gcloud config set project [PROJECT_ID]`
`gcloud config set compute/zone [COMPUTE_ZONE]`
`gcloud container clusters get-credentials [CLUSTER_NAME]`
* Run the deployment `kubeclt apply -f kubernetes/deployment.yml`