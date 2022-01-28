function updateStatus( id, currentStatus ) {

    const url = "http://localhost:8085/api/todos/" + id;

    const data = {
        isComplete : !currentStatus
    }

    console.log(data);

    fetch( url,
        {
            method: "PATCH",
            headers: {
                "Content-Type": "application/json",
            },
            body : JSON.stringify(data)
        })
        .then(
            (resp) => {
                if (resp.status === 200 ) {
                    location.replace("/");
                }
            }
        )
        .catch(
            (e) => {
                console.log(e);
            }
        )

}