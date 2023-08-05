import React,{ useState, useRef, useContext, useEffect } from 'react'
import { Form, Typography, Empty, Tabs } from 'antd'
import { UpOutlined, DownOutlined, TableOutlined } from '@ant-design/icons'
import _ from 'lodash'
import LineageBox from './lineage-box'
import FullScreenIcon from './img/full-screen.svg'
import ReturnScreenIcon from './img/return-screen.svg'
import FiledIcon from './img/filed-icon.svg'


const { Text } = Typography
const Page = ({data, taskDetail, catalogList}) => {
  const [form] = Form.useForm()
  const [showLog, setShowLog] = useState(true)
  const [isFullscreen, setIsFullscreen] = useState(false)
  const [isFold, setIsFold] = useState(false)

  function launchFullscreen(element) {
    setIsFullscreen(true)
    element.setAttribute('class', 'blood-related p16 full-screen')
  }

  function exitFullscreen(element) {
    setIsFullscreen(false)
    element.setAttribute('class', 'blood-related p16 small-screen')
  }
  
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

  const lineageBoxHeight = `${document.getElementsByTagName('body')[0]?.getBoundingClientRect().height - 50 - 57 - 80}px`

  return (
    <div className='FBV FBJB' style={{height: lineageBoxHeight}}>
      {
        data?.nodes?.length > 0 ?
        <div className='FBV FBJC white-bg'>
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
          
          <div className='blood-related p16 small-screen' id="lineageArea">
            <div className="btn-item FBH FBAC">
              {
                isFullscreen
                  ? <span className="circle-bg" title="reduce" onClick={() => exitFullscreen(document.getElementById("lineageArea"))}><img alt="" className="p6" src={ReturnScreenIcon} /></span>
                  : <span className="circle-bg" title="full screen" onClick={() => launchFullscreen(document.getElementById("lineageArea"))}><img alt="" className="p6" src={FullScreenIcon} /></span>
              }
              <div className='ml8' onClick={() => {setIsFold(!isFold)}}>
                {isFold ? <img className='hand' title='Field lineage' src={FiledIcon} height={14} width={20} /> : <TableOutlined className='lineage-switch-icon fs14 hand' title='Table lineage' />}
              </div>
            </div>
            {/* lineage */}
            <div className="" style={{height: lineageBoxHeight}}>
              <LineageBox isFold={isFold} data={data} taskDetail={taskDetail} catalogList={catalogList} />
            </div>
          </div>
        </div>
        : <Empty />
      }
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