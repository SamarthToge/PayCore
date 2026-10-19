Users(id,name,email,password,image,enabled,createdAt,updatedAt,provider,role)

Goals(id,amount,category,remark,status)

Loans(id,from,to,category,amount,remark,status)

Receipts(id,amount,category,remark,status,image,transactionId(foreign key))

Subscriptions(id,amount,startDate,cycleLength,category,status)

Transactions(id,from,to,amount,category)

Balance(userId(foreign key)(primary key),amount)