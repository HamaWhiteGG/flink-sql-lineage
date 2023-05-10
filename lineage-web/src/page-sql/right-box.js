import React,{ useState, useRef, useContext, useEffect } from 'react'
import { Form, Typography, Empty, Tabs } from 'antd'
import { UpOutlined, DownOutlined } from '@ant-design/icons'
import _ from 'lodash'
import LineageBox from './lineage-box'

const { Text } = Typography
const Page = ({data, taskDetail, catalogList}) => {
  const [form] = Form.useForm()
  const [showLog, setShowLog] = useState(true)
  const { taskLog='', taskStatus } = taskDetail
  const onChange = (key) => {
    console.log(key);
  }

  const items = [
    {
      key: '1',
      label: <span style={{color: 'red'}}>Error Message</span>,
      children: <div className='fs12 p8 log-info'>{taskLog}</div>,
    },
  ]

  const tabBarExtraContent = !showLog
    ? <UpOutlined className='fs12' onClick={() => setShowLog(!showLog)} />
    : <DownOutlined className='fs12' onClick={() => setShowLog(!showLog)} />
  

  useEffect(() => {
    if (taskStatus === 'FAILED') {
      setShowLog(true)
    } else {
      setShowLog(false)
    }
  }, [taskStatus])

  return (
    <div className='FBV FBJB' style={{height: 700}}>
      <div className='FBV FBJC' style={{height: 600}}>
      {
        data?.nodes?.length > 0
          ? <>
           {/* top info */}
            <div className="top-info-box p16 FBH FBJ">
              {
                !!taskDetail ?
                <Form
                  layout='inline'
                  form={form}
                  style={{
                    maxWidth: 800,
                  }}
                  size="small"
                >
                
                  <Form.Item label="Catalog" className='mr32'>
                    {/* <Select value="default">
                      <Option value="default">default</Option>
                    </Select> */}
                    
                    <Text type="secondary">
                      {catalogList?.filter(t => t.catalogId === taskDetail?.catalogId)[0]?.catalogName}
                    </Text>
                  </Form.Item>
                  <Form.Item label="Database">
                    <Text type="secondary">
                      {taskDetail?.database}
                    </Text>
                  </Form.Item>
                </Form>
                : null
              }
              
            </div>
            
            <div className=''>
              {/* lineage */}
              <div className="lineage-box pl16">
                <LineageBox data={data} taskDetail={taskDetail} catalogList={catalogList} />
              </div>
            </div>
          </>
          : <Empty />
      }
      </div>
      {
        taskStatus === 'FAILED'
        && 
        <div className='log-box gray-bd' style={{height: `${showLog ? '400' : '40'}px`}}>
          <Tabs 
          renderTabBar={() => 
            <div className='FBH FBJ gray-bg pl8 pr8'>
              <div className='p4 white-bg fs12' style={{color: 'red'}}>Error Message</div>
              {tabBarExtraContent}
            </div>
          } 
          tabBarStyle={{color: 'red'}} size="small" defaultActiveKey="1" items={items} onChange={onChange} tabBarExtraContent={tabBarExtraContent} />
        </div>
      }
    </div>
  )
}

export default Page