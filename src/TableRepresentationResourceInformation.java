public class TableRepresentationResourceInformation {
    private String resourceID;
    private String resourceName;
    private String resourceType;
    private Integer positionInQueue;

    public TableRepresentationResourceInformation(String resourceID,
                                                  String resourceName, String resourceType, Integer positionInQueue) {
        this.resourceID = resourceID;
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.positionInQueue = positionInQueue;
    }

    public String getResourceID() {
        return resourceID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getResourceType() {
        return resourceType;
    }

    public Integer getPositionInQueue() {
        return positionInQueue;
    }
}
