 
	//sad
// PUT YOUR CONTRACT'S ABI HERE

            var abi = [{"constant":true,"inputs":[{"name":"userId","type":"string"}],"name":"userExist","outputs":[{"name":"result","type":"bool"}],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getOverallContent","outputs":[{"name":"","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"contentId","type":"string"},{"name":"userId","type":"string"}],"name":"revokeAccess","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getLastPurchaseUserId","outputs":[{"name":"userId","type":"string"}],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getOverallUsers","outputs":[{"name":"","type":"uint256"}],"payable":false,"type":"function"},{"constant":true,"inputs":[{"name":"contentId","type":"string"},{"name":"userId","type":"string"}],"name":"hasAccess","outputs":[{"name":"","type":"bool"}],"payable":false,"type":"function"},{"constant":true,"inputs":[{"name":"contentId","type":"string"}],"name":"getPrice","outputs":[{"name":"p","type":"uint256"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"userId","type":"string"}],"name":"registerUser","outputs":[],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"contentId","type":"string"},{"name":"userId","type":"string"}],"name":"payForContent","outputs":[{"name":"","type":"string"}],"payable":true,"type":"function"},{"constant":true,"inputs":[],"name":"getEntitlement","outputs":[{"name":"","type":"address"}],"payable":false,"type":"function"},{"constant":false,"inputs":[{"name":"contentId","type":"string"},{"name":"price","type":"uint256"},{"name":"ownerAddress","type":"address"},{"name":"paymentAddress","type":"address"}],"name":"registerContent","outputs":[],"payable":false,"type":"function"},{"constant":true,"inputs":[{"name":"contentId","type":"string"}],"name":"contentExist","outputs":[{"name":"result","type":"bool"}],"payable":false,"type":"function"},{"constant":true,"inputs":[{"name":"contentId","type":"string"}],"name":"getNumberOfPurchases","outputs":[{"name":"p","type":"uint256"}],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getOverallRevenue","outputs":[{"name":"","type":"uint256"}],"payable":false,"type":"function"},{"constant":true,"inputs":[],"name":"getOverallPurchases","outputs":[{"name":"","type":"uint256"}],"payable":false,"type":"function"},{"inputs":[],"payable":false,"type":"constructor"}]

            // PUT YOUR UNIQUE DAPP ID HERE
            var dappId = "com.inacta.ch.apme";

            // PUT YOUR CONTRACT ADDRESS HERE
            var contractAddress = "0x3D6A11F2E4714cd8792147b1156D38155B919267";

            var walletBar = new WalletBar({
                dappNamespace: dappId,
                blockchain: "ropsten",
                callbacks: { signOut: function () { location.reload(); } }
            });

            var web3 = new Web3();
            var myContract;
            walletBar.applyHook(web3)
            .then(function() {
                
                myContract = web3.eth.contract(abi).at(contractAddress);

                //setInterval( function () {
                //    myContract.blue(function(e, c) { if(!e) document.getElementById("blues").innerText=c; });
                //    myContract.red(function(e, c) { if(!e) document.getElementById("reds").innerText=c; });
                //}, 1000);
            })
            .catch(function(err) {
                console.log(err);
            });

            function buy(price) {                
                finny = price*1000000000000000;
                
                var account = walletBar.getCurrentAccount(); // get account selected in wallet bar
                if (!account) return alert("You must log in to transact");
                walletBar.createSecureSigner();
                myContract.payForContent.estimateGas("apme_content", "apme_user",{ from: account, value: finny }, function (err1, gas) {
                  if(err1) return alert("Error: "+err1);             
                    myContract.payForContent.sendTransaction("apme_content", "apme_user", { gas: gas+200000, from: account, value: finny }, function (err2, hash) {
                        if(err2) return alert("Error: "+err2);
                        document.getElementById("status").innerText = "Last vote Tx ID: "+hash;
                    });
                });
            }

          